package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStream {
	public static void main(String[] args) {
		//향상된 for문을 이용한 여성목록 출력
		System.out.println("===향상된 for문을 이용한 여성목록 출력===");
		System.out.println("여성 목록 : ");
		for(People people : People.getPeapleList()) {
			if(people.getGender()==2) {
				System.out.println(people);
			}
		}
		//Stream의 filter를 이용한 여성목록 출력
		System.out.println("====Stream의 filter를 이용한 여성목록 출력====");
		List<People> femaleList = People.getPeapleList().stream().filter(people -> people.getGender()==1).collect(Collectors.toList());
		System.out.println("여성 목록 : ");
		femaleList.forEach(System.out::println);
	
		//stream()에서 제공하는 sorted()를 사용하면 원하는 필드로 정렬을 할 수 있다.
		List<People> sortedList = People.getPeapleList().stream().
				sorted(Comparator.comparing(People::getAge)).collect(Collectors.toList());
		System.out.println("나이순 목록 : ");
		sortedList.forEach(System.out::println);
		
		//stream()에서 제공하는 allMatch를 사용하면 모두 조건을 만족하는지 검사할 수 있다.
		boolean allMatch = People.getPeapleList().stream().allMatch(people -> people.getAge()>20);
		System.out.println("나이가 모두 20세이상인가?");
		System.out.println(allMatch);
		
		//stream()에서 제공하는 anyMatch를 사용하면 하나라도 조건을 만족하는지 알수있다.
		boolean anyMatch = People.getPeapleList().stream().anyMatch(people -> people.getAge()<29);
		System.out.println("나이가 모두 20세이상인가?");
		System.out.println(anyMatch);
		
		//stream()에서 제공하는 max를 사용하면 특정 필드를 기준으로 가장 큰 값을 가져올 수 있다.
		Optional<People> maxPeople = People.getPeapleList().stream().max(Comparator.comparing(People::getAge));
		if(maxPeople.isPresent()) {
			System.out.println("가장 나이가 많은 사람은?");
			System.out.println(maxPeople.get());
		} 
		/*
		 * 반대로 min이라는 메소드가 있다. 
		 */
		
//		// stream()에서 제공하는 collect와 Collectors.groupingBy를 사용하면 특정한 필드로 그룹을 만들어 맵을 만들 수 있다.
//		Map<Integer, List<People>> groupByGender = People.getPeapleList().stream().collect(Collectors.groupingBy(People::getGender));
//		System.out.println("남성/여성 목록");
//		groupByGender.forEach(gender, peopleList) -> {
//			System.out.println(gender);
//			peopleList.forEach(System.out::println
	
		//복합적으로 사용해보자 여성들 중 가장 나이가 많은 사람 출력
		Optional<People> oldestFemale = People.getPeapleList().stream().filter(people->people.getGender()==2).max(Comparator.comparing(People::getAge));
		System.out.println("나이가 가장 많은 여자는?");
		oldestFemale.ifPresent(System.out::println);
		
	}
}

