package com.hcl.java8;

public class CalculatorMain {

public static void main(String[ ] args) {
	Calculator calculator = new Calculator();
	// first param to calc method is BiFunction type so lambda ok.
	Integer addResult = calculator.calc((x, y)-> x + y , 10, 5);
	Integer subResult = calculator.calc((x, y)-> x - y , 20, 5);
    System.out.println (addResult);
 	System.out.println (subResult);
    }
}
