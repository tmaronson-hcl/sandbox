package com.hcl.java8;

import java.io.IOException;
import java.util.Properties;

public class CalculatorMain {

public static void main(String[ ] args) throws IOException {
	Calculator calculator = new Calculator();
	// first param to calc method is BiFunction type so lambda ok.
	Integer addResult = calculator.calc((x, y)-> x + y , 10, 5);
	Integer subResult = calculator.calc((x, y)-> x - y , 20, 5);
    System.out.println (addResult);
 	System.out.println (subResult);
 	
    }
}
