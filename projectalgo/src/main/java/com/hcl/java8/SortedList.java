package com.hcl.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class SortedList {

	public static void main(String[] args) {
		sortAndTasks();

	}

	private static void sortAndTasks() {

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(10, "Arun", 1010f, 'E'));
		list.add(new Employee(20, "Babu", 2020f, 'M'));
		list.add(new Employee(30, "Carol", 3030f, 'M'));
		list.add(new Employee(40, "Danny", 4040f, 'C'));
		list.add(new Employee(50, "Anthony", 5050f, 'M'));
		list.stream().filter((emp) -> emp.getEmpName().startsWith("A"))
				.forEach((emp) -> System.out.printf("name is %s%n", emp.getEmpName()));
		// 1. Sort by last name
		Collections.sort(list, (emp1, emp2) -> {
			return emp1.getEmpName().compareTo(emp2.getEmpName());
		});
		// 2. print all names
		System.out.println("lambda way to print all names");
		list.forEach((emp) -> System.out.println(emp.getEmpName()));
		// old way to print name
		System.out.println("older, pre Java 8 way to print all names");
		for (Employee emp : list) {
			System.out.println(emp.getEmpName());
		}

		// 3. Print all names that begin with 'A' but don't use Stream interface yet.
		System.out.println("Print names that begin with 'A'");
		Predicate<Employee> name = (emp) -> emp.getEmpName().startsWith("A");
		list.forEach( (e) -> {
			if(name.test(e)) 
				System.out.println(e.getEmpName());
			});
			/*
			 * for (Employee emp : list) { if (name.test(emp)) {
			 * System.out.println(emp.getEmpName()); } }
			 */
	}

}