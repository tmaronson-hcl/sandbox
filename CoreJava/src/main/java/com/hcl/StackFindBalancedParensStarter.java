package com.hcl;

import java.util.Stack;

class Parser2 {
	boolean isBalanced(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '{') {
				st.push(c);
				continue;
			}

			if (c == '}') {
				if (st.empty() || st.pop() != '{')
					return false; // stack is empty but String still has ) or next char not opening (
			}
		}
		if (st.empty()) {
			return true;
		}
		return false;
	}
}

public class StackFindBalancedParensStarter {

	public static void main(String[] args) {
		Parser2 parser = new Parser2();
		String str = "{{}}";
		System.out.println(parser.isBalanced(str));

	}
}
