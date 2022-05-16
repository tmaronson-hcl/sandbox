package com.hcl;

public class AbacabaPattern {
	
	static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	public static String abacabaPattern(int n) {
		
		if(n == 1) return "A";
		if(n == 2) return "ABA";
		return abacabaPattern(n-1) + alphabet[n - 1] + abacabaPattern(n-1);
	}
}
