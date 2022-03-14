package com.hcl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdasBasic {

	public static void main(String[] args) {
		
		List<Student> names = Arrays.asList(
		new Student(56, "Jones"),
		new Student(67, "Bulls"),
		new Student(45, "Cuggy"),
		new Student(90, "Jackson"),
		new Student(75, "Aarons"),
		new Student(70, "Irkens"));
		lambdaWork(names);

	}

	private  static void lambdaWork(List<Student> names) {

		// print names in sorted order
		names.stream()
			 .sorted((n1, n2) -> n1.getName().compareTo(n2.getName()))
			 .forEach(System.out::println);
		
		// print all names
		System.out.println("Print all names");
		names.stream()
		     .forEach(System.out::println);
		
		System.out.println("Print all names");
		names.stream()
		     .forEach((n) -> System.out.println(n));
		
		System.out.println("Print names starting with C");
		names.stream()
			 .filter(x -> x.getName().startsWith("C"))
		     .forEach(System.out::println);
	}

}
