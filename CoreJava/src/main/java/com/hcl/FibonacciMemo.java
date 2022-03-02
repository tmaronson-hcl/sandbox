package com.hcl;

public class FibonacciMemo {

	public static void main(String[] args) {
		System.out.println("Recursive fib with array = " 
				+ fib(Integer.parseInt(args[0])));
	}

	/*
	 * Fibonacci sequence: 0,1,1,2,3,5,8,13,21,... return the nth Fibonacci number
	 * What is big O here for recursion?
	 */
	static long[] memo = new long[100];

	static long fib(int n) {
		if (n == 0) return 0; // fib(1) = 0
		if (n == 1)	return 1; // fib(2) = 1

		if (memo[n] == 0)
			memo[n] = fib(n - 1) + fib(n - 2); // recursion
		return memo[n];
	}
}
