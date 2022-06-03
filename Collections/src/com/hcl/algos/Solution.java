package com.hcl.algos;

public class Solution {

	public static void main(String[] args) {
			// input to our class from HR
	}
	
	// Sum ints from i to j inclusive, then add to sum all ints down to k
	long getSum(int i, int j, int k) {
		long sum = 0;
		for(int a = i; a <= j; a++) {
			sum += a;
		}
		for( int b = j - 1; b >= k; b-- )
			sum += b;
		return sum;
	}
	
}

class Student {
	/*
	 * 1. student has a name, id What are these? variables
	 * 2. increment the id automatically when a new Student is created - constructor
	 * 3. toString() method - what is this? (Object class)
	 */
	 String name;
	 static int id = 0;
	
	public Student(String name) {
		this.name = name;
		id++;
	}
	
	@Override
	public String toString() {
		return id + ": " + name;
	}
	
}
