package com.hcl;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.*;

import java.text.NumberFormat;

// Example 1 2 3 + 4 5 * * + = 101
public class StackPostFix {
	
	private Stack<Double> stack = new Stack<Double>();

	// Could be refactored and put in separate class but no big deal now.
	public static void main(String[] args) {

		System.out.print("Please enter numbers or operators separated by a space including 'sqrt' if you want: ");
		new StackPostFix().calcPostFixValue();
	}

	// Infix - Left child ->Root -> Right child
	// Postfix - Left -> Right -> Root 
	private void calcPostFixValue() {
				
		try (Scanner sc = new Scanner(System.in);) {  // try with resources so Scanner will be closed.
			String[] tokenArr = sc.nextLine().split("\\s"); //\s is regex for whitespace
			for (String token : tokenArr) {
				if (token.equals("*"))
					stack.push(stack.pop() * stack.pop());
				else if (token.equals("+"))
					stack.push(stack.pop() + stack.pop());
				else if ((token.equals("-")))
					stack.push(-(stack.pop() - stack.pop())); // - not commutative
				else if ((token.equals("/")))
					stack.push(1.0 / stack.pop() * stack.pop()); 
				else if ("sqrt".equals(token))
					stack.push(sqrt(stack.pop()));
				else
					stack.push(Double.parseDouble(token));
			}
		} catch (EmptyStackException ex) {
			System.err.println("Stack is empty so please debug your code or input!");
			ex.printStackTrace();
		} catch (NumberFormatException nex) {
			System.err.println("Problem with numeric format!");
			nex.printStackTrace();
		} catch (Exception ex) {
			System.err.println("Uh-oh, we have a problem!");
			ex.printStackTrace();
		}
		printUtil();
	}
	
	// This could be refactored later into a separate utility class, as a static method maybe.
	void printUtil() {
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		// Avoid many decimal places.
		nf.setMaximumFractionDigits(2);
		if(!stack.empty()) 
			System.out.print(nf.format(stack.pop()));
	}

}
