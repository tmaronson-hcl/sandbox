package com.hcl.java8;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.println("in main method");
		Thread th = new Thread(() -> System.out.println("new Thread"));
	    th.start();
	}

}
