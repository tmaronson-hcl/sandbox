package com.hcl;

import java.util.Arrays;

public class Student implements Comparable<Student> {

	private int score;
	private String name;

	public Student(int score, String name) {
		// super();
		this.score = score;
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	// Best practice to base equals() and hashCode() method on same fields.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Student other) { // could use this.score - other.score but do that in another example
		/*
		 * if (this.getScore() > other.getScore()) { return 1; } else if
		 * (this.getScore() < other.getScore()) { return -1; } else { return 0; }
		 */
		return this.score - other.score;
		//return name.compareTo(other.name);
	}

	@Override
	public String toString() {
		
		return "Student [score=" + score + ", name=" + name + "]";
	}

}
