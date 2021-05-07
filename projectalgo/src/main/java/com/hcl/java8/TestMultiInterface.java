package com.hcl.java8;

public class TestMultiInterface {
    public static void main(String[] args) {
	MultiInterface myInterface1 = name -> name + " World";
	//Logic of sayHello
	System.out.println(myInterface1.sayHello("Hello"));
	//Accessing static method
	System.out.println(MultiInterface.add(1, 2));
	//Accessing default method
	System.out.println(myInterface1.defaultMethod(10));
	//another interface object
	MultiInterface myInterface2 = (name) -> (name + " World");
	//Accessing the equals method
	System.out.println(myInterface1.equals(myInterface2));
    }
}