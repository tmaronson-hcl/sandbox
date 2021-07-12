package com.hcl.java8;

import java.util.function.BiFunction;

public class CalculatorEx2 {
  
    interface IntegerMath {
        int operation(int a, int b); 
     }
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
    
    public double binaryOp(double a, double b) {
    	return a + b;
    }
 
    public static void main(String... args) {
    
        CalculatorEx2 myApp = new CalculatorEx2();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        IntegerMath mult = (c, d) -> c*d;
        System.out.println("22 + 68 = " + addition.operation(22, 68));
        System.out.println("22 - 68 = " + subtraction.operation(22, 68));
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));  
        System.out.println("20*10 = " +
                myApp.operateBinary(20, 10, mult)); 
        // Use method reference
        BiFunction<Double, Double, Double> addDoubles = new CalculatorEx2()::binaryOp;
        System.out.println(addDoubles.apply(45.1, 56.8));
    }
}
