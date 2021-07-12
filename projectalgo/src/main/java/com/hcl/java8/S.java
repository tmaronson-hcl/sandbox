package com.hcl.java8;

import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

class S {
	public static void main(String[] args) {
		String s = "Java";
		s = s.concat(" SE 6");
		s = s.replace('6', '7');
		System.out.print(s + "\n");
		S streams = new S();
		streams.streamsList();
		streams.streamsMap();
	}
	
	private void streamsMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Bob", 1);
		map.put("Alice", 2);
		map.put("Ted", 3);
		map.put("Herb", 4);
		map.put("T", 5);
		map.forEach((key, val) -> System.out.println(val));
	}
	
	void streamsList() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,12,56,32);
		numbers.forEach((i) -> System.out.println(pow(i, 2)));
		System.out.println(numbers.stream()
			.mapToInt(e -> e*2)
			.sum()
		);
		Supplier <List<Integer>> list = ArrayList<Integer>::new; 
		Collection<String> names = new LinkedHashSet<>(); 
		names.addAll(Arrays.asList("Elsie", "Lucy", "Dorothy", "Mary", "Margaret")); 
		names.removeIf(name -> name.contains("y")); 
		names.forEach(System.out::println); // prints: Elsie Margaret
	}
}