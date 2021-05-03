package com.hcl.exceptions;

public class MultipleTryBlock {

	public static void main(String[] args) {
		
		try {
		int[] arr = {1, 2};
		arr[2] = 3/0;
		} catch (ArithmeticException ae) {
			System.out.println("divide by zero");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("array inde out of bounds exception");
		}

	}

}
