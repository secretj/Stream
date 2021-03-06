package stream;

import java.util.Arrays;
import java.util.List;

public class People {

	private String name;
	private int age;
	private int gender;
	
	public People(String name, int age, int gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String toString() {
		return "People(name="+ name + ", age=" + age + ", gender="+gender+")";		
	}
	
	public static List<People> getPeapleList(){
		return Arrays.asList(
				new People("박진형", 29, 1),
				new People("유철우", 28, 1),
				new People ("고인정", 23, 2),
				new People("박보영", 33, 2)
				);
				
	}
	
}
