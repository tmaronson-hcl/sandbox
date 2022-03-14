package com.hcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DriverSort {

	public static void main(String[] args) {
		
		new DriverSort().init();

	}

	private void init() {
		
		// What happens if I use HashSet, TreeSet
		List<Student> names = new ArrayList<>();
		names.add(new Student(56, "Jones"));
		names.add(new Student(67, "Bulls"));
		names.add(new Student(45, "Cuggy"));
		names.add(new Student(90, "Jackson"));
		names.add(new Student(75, "Aarons"));
		names.add(new Student(70, "Irkens"));
		Collections.sort(names); // How does it know how to sort Student objects?
		System.out.println(names);
		names.stream()
			 .forEach(student -> System.out.println(student.hashCode()));
		     
		

	}

}
