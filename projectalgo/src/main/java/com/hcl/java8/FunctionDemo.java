package com.hcl.java8;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        Function<Integer, Double> third = i -> i/3.0;
        Function<String, Boolean> strLen = s -> s.length () == 6;
        System.out.printf("%.2f\n", third.apply (11));
        System.out.printf("%s\n", strLen.apply ("Hobart"));
    }
}
