package com.hcl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMaps {

	public static void main(String[] args) {
		
		/* LinkedHashMap guarantees adding entries in order but still 
		 * does not accept duplicate keys.
		 */
		Map<Integer, String> ageName = new LinkedHashMap<>();
		ageName.put(22,  "Abey");
		ageName.put(33,  "Billy");
		ageName.put(2,  "Dawn");
		ageName.put(2,  "Sherry");
		ageName.put(100,  "Jim");
		System.out.println(ageName);
		// good way to use enhanced for loop to loop through Map
		for(Map.Entry<Integer, String> map : ageName.entrySet()) {
			System.out.printf("key = %s, value = %s\n", map.getKey(), map.getValue());
		}
		// LinkedHashMap copy
		Map<Integer, String> copy = new LinkedHashMap<>(ageName);
		System.out.println(copy);
		// HashMap does not add entries in order necessarily.
		Map<Integer, String> ageName2 = new HashMap<>();
		ageName2.put(22,  "Abey");
		ageName2.put(33,  "Billy");
		ageName2.put(2,  "Dawn");
		ageName2.put(2,  "Sherry");
		ageName2.put(100,  "Jim");
		System.out.println(ageName2);
	}

}
