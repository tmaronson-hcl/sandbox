package com.hcl.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MultipleCatchBlockPipes {

	public static void main(String[] args) {
		
		try {
		int[] arr = {1, 2};
		arr[2] = 3/0; 
		/*	shows right to left associativity with = operator
		 *  because two exceptions in above statement
		 */
		//arr[33] = 8;
		FileReader file = new FileReader("./examplessss.txt");
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | FileNotFoundException ex) {
			System.out.println(ex);
		} 

	}

}
