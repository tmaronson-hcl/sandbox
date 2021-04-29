package com.hcl.algos;

public class Fibonacci {
	
	static long fib(long n) {
		
		if(n == 1 || n == 0) {
			return n;
		}
		return fib(n) + fib(n - 1);
	}
	

	public static void main(String[] args) {
		
		System.out.println("Fib. number is " + fib(5));
		
	}

}
