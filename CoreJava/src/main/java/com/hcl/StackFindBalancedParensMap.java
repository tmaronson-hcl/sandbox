package com.hcl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // can investigate JOptionPane
import java.util.Stack;

class ParserWithMap {

	boolean isBalanced(String s, Map<Character, Character> map) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('q' == c || 'Q' == c) { // to quit input
				System.out.println("Bye!");
				System.exit(0);
			}
			if (map.containsKey(c)) {
				st.push(c);
				continue;
			}
			if (!st.empty() && c == map.get(st.peek())) { // closing character
				st.pop();
				continue;
			}
		}
		return st.isEmpty();
	}
}

public class StackFindBalancedParensMap {

	public static void main(String[] args) {

		scan();

	}

	private static void scan() {

		Map<Character, Character> map =  new HashMap();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		ParserWithMap parser = new ParserWithMap();
		Scanner in = new Scanner(System.in); // Check out Scanner
		String prompt = "";
		System.out.print("Please enter string to test: Q to quit: ");
		while (!"q".equalsIgnoreCase(prompt)) {
			prompt = in.next();
			boolean balanced = parser.isBalanced(prompt, map);
			System.out.println(balanced);
			System.out.print("Please enter string to test: Q to quit: ");
		}
		in.close();
	}
}
