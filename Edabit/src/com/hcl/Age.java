package com.hcl;

public class Age {

	public static int calcAge(int age) throws Exception {
		if(age < 0) throw new Exception();
		return age*365;
	}
}
