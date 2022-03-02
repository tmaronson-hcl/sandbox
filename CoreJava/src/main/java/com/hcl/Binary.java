package com.hcl;

public class Binary {

	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		System.out.println(convert(n));

	}

	public static String convert(int n) {
		if(n == 1) return "1";
		return convert(n/2) + (n % 2);
		
	}

}
