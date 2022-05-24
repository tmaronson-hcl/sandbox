package com.hcl.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class LetterCounts {

	public static void main(String[] args) {
		String str = "bgghhiklmnoopptyaadfcbaafebecdaf";
		String value = JOptionPane.showInputDialog(null, "Enter value", "Sample", JOptionPane.OK_CANCEL_OPTION);
		new LetterCounts().countChars(str);
	}
	
	void countChars(String str) {
		
		int val = 0;
		int maxVal = 0;
		char maxChar = '_';
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!map.containsKey(ch)) {
				val = 1;
			} else {
				val = map.get(ch);
				val++;
			}
			if(val > maxVal) {
				maxVal = val;
				maxChar = ch;
			}
			map.put(ch, val);
			
		}
		System.out.println(map);
		System.out.printf("Character most frequency simple method is '%s' at position %d\n", 
				maxChar, str.indexOf(maxChar));
		
		// Streams method - hard to read
		Map<Character, Integer> counts = new HashMap<>();
		for (char c : str.toCharArray()) {
		    counts.merge(c,                  // key = char
		                1,                  // value to merge
		                Integer::sum);      // counting
		}
		System.out.println("letter counts:\n" + counts);
		
		//Another way with Streams
		char[] chars = str.toCharArray();
		LinkedHashMap<Object, Long> sortedMap = new LinkedHashMap<>();
		Stream<Object> cStream =
		IntStream
				.range(0, chars.length)
				.mapToObj((i -> chars[i]));
		Map<Object, Long> charMap = cStream.collect(Collectors
				.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charMap);
		charMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		System.out.println(sortedMap);		
		Object[] arr = sortedMap.entrySet().toArray();
		char maxChar2 = arr[arr.length - 1].toString().charAt(0);
		System.out.printf("Character most frequency is '%s' at position %d", 
				maxChar2, str.indexOf(maxChar2));
		
	}

}
