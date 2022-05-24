package com.hcl.streams;

import java.util.Arrays;
import java.util.List;

public class StreamStuff {
	
	public static void main(String[] args) {
		
		List<String> listStr = Arrays.asList("this", "is", "very", "much", "fun", "without", "question");
		String str = listStr.stream()
		.filter(s -> s.length() > 3)
		.map(s -> s.toUpperCase())
		.reduce((s,t) -> s + t)// concatenate Strings
		.get();
		//.forEach(s -> System.out.println(s)); // );
		System.out.println(str);
				
		long count = listStr.stream()
		.filter(s -> s.length() > 3)
		.map(s -> s.toUpperCase())
		.count(); 
		
		listStr.stream()
		.filter(s -> s.length() > 3)
		.map(s -> s.toUpperCase())
		.forEach(System.out::println); // method reference
		
		System.out.printf("The string is %s and count is %d", str, count);
		 
		
	}

}
