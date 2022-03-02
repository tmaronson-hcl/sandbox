package com.hcl;

import java.util.Scanner;
import java.util.Stack;

// HR is not correct as their original stub code has String return type instead of boolean.
class Parser {
	boolean isBalanced(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// Refactor later with fewer if's
			if (c != '{' && c != '}' && c != '(' && c != ')') {
				if('q' == c || 'Q' == c)
					System.exit(0);
				continue;
				//System.err.println("Insert valid characters! () {}");
				//System.exit(1);
			}
			if (c == '{' || c == '(') { // two sets of block characters () and {}
				st.push(c);
				continue;
			}
			if (c == '}') {
				if (st.isEmpty() || st.pop() != '{')
					return false; // stack is empty but String still has } or next char not opening {
			}
			if (c == ')') {
				if (st.empty() || st.pop() != '(')
					return false; // stack is empty but String still has ) or next char not opening (
			}
		}
		if (st.empty()) {
			return true;
		}
		return false;
	}
}

public class StackFindBalancedParens {

	public static void main(String[] args) {

		Parser parser = new Parser();
		Scanner in = new Scanner(System.in);
		String prompt = "";
		System.out.print("Please enter string to test: Q to quit: ");
		while (!"q".equalsIgnoreCase(prompt)) {
			prompt = in.next();
			System.out.println(parser.isBalanced(prompt));
			System.out.print("Please enter string to test: Q to quit: ");
		}

		in.close();
	}
}
