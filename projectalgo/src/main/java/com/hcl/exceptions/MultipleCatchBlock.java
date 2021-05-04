package com.hcl.exceptions;

public class MultipleCatchBlock {

	public static void main(String[] args) {

		try {
			int[] arr = { 1, 2 };
			arr[2] = 3 / 2;  // associativity is right to left for = operator
		} catch (ArithmeticException ae) {
			System.out.println("divide by zero");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of bounds exception");
		} catch (Exception e) {
			System.out.println("general exception");
		} finally {
			System.out.println("finally block reached?");
		}

	}

}
