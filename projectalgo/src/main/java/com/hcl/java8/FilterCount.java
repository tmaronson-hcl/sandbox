package com.hcl.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class FilterCount {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(10, "Arun", 1010f, 'M'));
		list.add(new Employee(20, "Babu", 2020f, 'M'));
		list.add(new Employee(30, "Carol", 3030f, 'F'));
		list.add(new Employee(40, "Danny", 4040f, 'M'));
		list.add(new Employee(50, "Anthony", 5050f, 'M'));
		Long noOfRecords = list.stream().count();
		System.out.printf("number of input records is %s%n", noOfRecords);

		//How many male and female emps are there in this org
		
		/*
		 * 1. Collection list has Stream stream() method.
		 * 2. Stream method is collect(Collector)
		 * 3. Method Collectors.groupBy(Function, Collector) returns Collector in param in #2.
		 * 4. Function is Employee::getBand, Collectors.counting() method returns Collector for #3.
		 */
		Map<Character, Long> noOfMaleAndFemaleEmps = list.stream()
				.collect(
				Collectors.groupingBy(Employee::getBand, Collectors.counting())
				);
		System.out.println(noOfMaleAndFemaleEmps);
		
		Double sumSalary = list.stream()
				.collect(
				Collectors.summingDouble(Employee::getSalary));
		System.out.println(sumSalary);
		
		Long empSalGt3000 = list.stream()
				.filter((var) -> var.getSalary() > 3000)
				.count();
		System.out.printf("number of emps with salary > 3000 is %d%n", empSalGt3000);
	}
}
