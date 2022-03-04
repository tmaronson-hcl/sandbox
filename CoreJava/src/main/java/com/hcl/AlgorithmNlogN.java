package com.hcl;

import java.util.Scanner;

import static java.lang.Math.*;

public class AlgorithmNlogN {

	public static void main(String[] args) {

		int value = 0;
		System.out.print("Enter an integer: ");
		try (Scanner sc = new Scanner(System.in);) {
			if (sc.hasNextInt()) {
				value = sc.nextInt();
			} else {
				throw new RuntimeException("Something wrong here!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		new AlgorithmNlogN().beginAlgo(value);

	}

	private void beginAlgo(int n) {

		// What is Big(O)?
		int counter = 0;
		for (int i = 0; i < n; i++) {
			counter++;
			for (int j = n; j > 0; j = j / 2) {
				counter++;
			}
		}
		System.out.printf("%d steps and %6.0f Big(O) predicted ", 
				counter, n * log(n) / log(2));
	}

}
