package com.hcl.algos;

public class DeterminePalindrome {

	public static void main(String[] args) {
		
		String testString = "abbvvvbba";
		System.out.println(new DeterminePalindrome().isPalindrome(testString));
		System.out.println(new DeterminePalindrome().isPalindrome2(testString));

	}

	private boolean isPalindrome2(String testString) {
		
		StringBuilder sb = new StringBuilder(testString);
		return testString.equals(sb.reverse().toString());
	}

	private boolean isPalindrome(String testString) {
		char[] charArray = testString.toCharArray();
		int i = 0;
		int n = charArray.length - 1;
		int len = charArray.length;
		// base case for odd length
		while(true) {
			if(i == n && len % 2 == 1) {
				return true;
			}
			// base case for even length
			if(i == n + 1 && len % 2 == 0) {
				return true;
			}
			if(!(charArray[i++] == charArray[n--])) {
				return false;
			}
				
		}
		
	}

}
