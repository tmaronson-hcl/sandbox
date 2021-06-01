package com.company.stack;

public class Stack<T> {

	private Node head = null;
	private Node tail = null;
	private int size;

	class Node {

		T data;
		Node next;
		Node previous;

		public Node(T data) {
			this.data = data;
			next = null;
			previous = null;
		}
	}

	// This method shouldn't actually return a node like pop() method.
	public void peek() {

		if (tail == null) {
			System.out.println("Stack is empty!");
			return;
		} else {
			System.out.println("Value of top node is " + tail.data);
		}
	}

	public T pop() {

		if (tail == null) {
			throw new RuntimeException();
		}
		Node popNode = tail;

		if (head.next == null) {  // only node remaining
			head = null;
		} else {
			tail.previous.next = null; // popped node is null
		}

		tail = popNode.previous;
		size--;
		return popNode.data;

	}

	public void push(T element) {

		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.previous = null;
			newNode.next = null;

		} else {
			newNode.previous = tail;
			tail.next = newNode;

		}
		tail = newNode;
		size++;
	}

	void display() {

		Node currentNode = head;
		while (currentNode != null) {
			System.out.println("Node value is " + currentNode.data);
			currentNode = currentNode.next;
		}
	}

	int size() {

		return size;

	}

}
