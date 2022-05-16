package com.hcl;

public class LongDigits {
	//static int counter = 0; // must use for case n = 0 initially Test case 01
	public static int digitsCount(long n) {
		// recursive solution here
		//if(n/10 == 0 && counter == 0) return 1;
		if(n/10 == 0)
			return 1;
		//else if(n == 0 && counter > 0) return 0;
		//counter++;
		else 
			return digitsCount(n/10) + 1;
	}
}
