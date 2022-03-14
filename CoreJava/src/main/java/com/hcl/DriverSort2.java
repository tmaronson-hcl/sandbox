package com.hcl;

import java.util.Set;
import java.util.TreeSet;

public class DriverSort2 {

	public static void main(String[] args) {
		
		new DriverSort2().init();

	}

	private void init() {
		
		/*
		 * TreeSet constructor can take Comparator so use lambda expression.
		 * No method name compareTo is necessary with lambda.
		 * No specification of type of parameters are necessary.
		 * No class name that implements Comparator is necessary.
		 */
		Set<Student2>set = new TreeSet<>((google, gaggle) -> 
			 google.name.compareTo(gaggle.name));
			// return self.score - other.score // if we want to compare numeric scores
			
		//);
		set.add(new Student2(56, "Jones"));
		set.add(new Student2(67, "Bulls"));
		set.add(new Student2(45, "Cuggy"));
		set.add(new Student2(90, "Jackson"));
		set.add(new Student2(75, "Aarons"));
		set.add(new Student2(70, "Irkens"));
		System.out.println(set);

	}

}
