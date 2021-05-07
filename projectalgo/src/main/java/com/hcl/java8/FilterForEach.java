package com.hcl.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterForEach {

public static void main(String[] args) {
	List<Employee> list = new ArrayList<Employee>();
	list.add(new Employee(10, "Arun", 3010f, 'E'));
	list.add(new Employee(20, "Babu", 2020f, 'M'));
	list.add(new Employee(30, "Carol", 3030f, 'M'));
	list.add(new Employee(40, "Danny", 4040f, 'C'));
	list.add(new Employee(50, "Anthony", 5050f, 'M'));
	list.stream()
		.sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
		.forEach(System.out::println);
	System.out.println("Sort by name");
	list.stream()
		.sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()))
		.forEach(System.out::println);
	
	
	
		    //.forEach((emp) -> System.out.printf("name is %s%n", emp.getEmpName()));
	
   }
}