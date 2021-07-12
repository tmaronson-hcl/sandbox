package com.hcl.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	 String name;
	 int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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
}
public class LambdaExpression {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Vivek", 18), 
				new Person("Vijay", 23),  new Person("Pari", 28),
				new Person("David", 12));
		Map<Integer, String> map = persons.stream()
				.collect(Collectors.toMap(
						p -> p.age, 
						p -> p.name, 
						(name1, name2) -> name1 + ";" + name2));
	          System.out.println(map);
	          Arrays.asList("Arvind", "Aaron", "Anton", "Tony", "Vaishak", "Sheela")
	          .stream()
	          .peek(System.out::println)
	          // Look up allMatch(Predicate) and see why weird results may be returned.
	          .allMatch(s -> s.startsWith("A"));
	          
	          System.out.println("This would be what we want to do more than likely");
	          Arrays.asList("Arvind", "Aaron", "Anton", "Tony", "Vaishak", "Sheela")
	          .stream()
	          .filter(s -> s.startsWith("A"))
	          .forEach(System.out::println);
	          
	          

	}
}

