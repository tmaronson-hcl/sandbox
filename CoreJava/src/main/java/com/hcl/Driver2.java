package com.business.treeset;

import java.util.Set;
import java.util.TreeSet;

public class Driver2 {

	public static void main(String[] args) {
		
		new Driver2().init();

	}

	private void init() {
		
		/*
		 * TreeSet constructor can take Comparator so use lambda expression.
		 */
		Set<Student>set = new TreeSet<>((self, other) -> {
			return self.score - other.score;
		});
		set.add(new Student(56, "Jones"));
		set.add(new Student(67, "Bulls"));
		set.add(new Student(45, "Cuggy"));
		set.add(new Student(90, "Jackson"));
		set.add(new Student(75, "Aarons"));
		set.add(new Student(70, "Irkens"));
		System.out.println(set);

	}

}
