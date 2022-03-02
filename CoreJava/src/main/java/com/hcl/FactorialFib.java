package com.hcl;

public class FactorialFib {

	public static void main(String[] args) {
		System.out.println("recursion fact = " + factorial(6));
		System.out.println("fact loop = " + factorialLoop(6));
		System.out.println(fib(54));
	}
	
	/*
	 * 5! = 5*4*3*2*1
	 * Return the factorial of n. What is big O here for recursion?
	 */
	static long factorial(long n) {
		
		if(n == 0) {
			return 1;
		}
		return n*factorial(n - 1); // recursion
	}
	
	static long factorialLoop(long n) {
		
		long product = 1;
		for (int i = 1; i <= n; i++) {
			product *= i;
		}
		return product;
	}
	
	/*
	 * Fibonacci sequence: 0,1,1,2,3,5,8,13,21,... 
	 * return the nth Fibonacci number What is big O here for recursion?
	 */
	static long fib(int n) {
		if(n == 0) { // fib(2) = 1
			return 0;
		}
		if(n == 1) { // fib(1) = 0 base case
			return 1;
		}
		return fib(n - 1) + fib(n - 2); // recursion
	}

}
