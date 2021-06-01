package com.company.stack;

import java.util.Scanner;

public class StackSimDriver {

	public static void main(String[] args) {

		new StackSimDriver().input();

	}

	private void input() {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int value = 0;
		while (value != 999) {
			System.out.println("Enter 999 to quit!");
			System.out.print(" Enter a value for the stack: ");

			if (sc.hasNextInt()) {
				value = sc.nextInt();
			} else {
				sc.next();
				continue;
			}

			if (value != 999) {
				stack.push(value);
			}

		} 

		stackEval(stack);
		sc.close();
	}

	private void stackEval(Stack<Integer> stack) {

		stack.display();
		System.out.println(stack.size());
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		System.out.println(stack.size());
		stack.peek();

	}

}

/*
 * How could we improve or refactor #9 at 
 * https://sahandsaba.com/nine-anti-patterns-every-programmer-should-be-aware-of-with-examples.html#premature-optimization?
 * i.e. how can we simulate push, pop, size of stack, isEmpty, display method outside stack
 * and any other methods?
 * Some ideas? Inner class Node in a stack like a single or doubly linked list.
 * Stack class members? Node with data, pointer or ref to next Node, maybe ref to previous node
 * int or related size, head, tail to keep updating.
 * Do we have to say always push at head and pop at head - LIFO?
 * Creating client to prompt for values - exceptions, looping (when to quit?)
 * Client can also display. What is key here? - currentNode ref and iterate until null or tail->null
 * 
 */
