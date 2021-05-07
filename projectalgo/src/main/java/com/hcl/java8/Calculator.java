package com.hcl.java8;

import java.util.function.BiFunction;

public class Calculator {
//Represents a function that takes two arguments of types T and U, and returns a result of type R.

 public Integer calc(BiFunction<Integer, Integer, Integer> bi ,        
             Integer num1 , Integer num2) {
      return bi.apply(num1,num2);
  }
}
