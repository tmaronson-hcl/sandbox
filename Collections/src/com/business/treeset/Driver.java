package com.business.treeset;

import java.util.Set;
import java.util.TreeSet;

public class Driver {

	public static void main(String[] args) {
		
		new Driver().init();

	}

	private void init() {
		
		Set<Student>set = new TreeSet<>();
		set.add(new Student(56, "Jones"));
		set.add(new Student(67, "Bulls"));
		set.add(new Student(45, "Cuggy"));
		set.add(new Student(90, "Jackson"));
		set.add(new Student(75, "Aarons"));
		set.add(new Student(70, "Irkens"));
		System.out.println(set);

	}

}
