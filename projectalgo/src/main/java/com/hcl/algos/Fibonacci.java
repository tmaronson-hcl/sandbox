package com.hcl.algos;

public class Fibonacci {  // What is Fibonacci sequence? 0 1 1 2 3 5   map - key - value pair
	
	static long fib(long n) {
		
		if(n <= 1) { // base case
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
	

	public static void main(String[] args) {
		
		System.out.println("Fib. number is " + fib(66));
		
	}

}
