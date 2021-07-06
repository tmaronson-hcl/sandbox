package com.hcl;

import java.math.BigInteger;

public class StringNumbers {

    public static void main(String[] args) {
       System.out.println(add("212", "13"));
       System.out.println(add("212ccc", "13"));
        System.out.println(add("", "13"));
        System.out.println(add("212", ""));
        System.out.println(add("212343434344444444444444444444444444444444",
                "555555555555555555555555555555555555555555555555555555"));
    }

    public static String addStrNums(String num1, String num2) {
        try {
            BigInteger big1 = new BigInteger(num1);
            BigInteger big2 = new BigInteger(num2);
            BigInteger sum = big1.add(big2);
            return sum.toString();
        } catch (NumberFormatException ex) {
            if("".equals(num1) && "".equals(num2)) return "0";
            if(num1.equals("")) return num2;
            if(num2.equals("")) return num1;
            return "-1";
        }
    }

    public static String add(String num1, String num2) {
        if("".equals(num1) && "".equals(num2)) return "0";
        if(num1.equals("")) return num2;
        if(num2.equals("")) return num1;
        // Use case that string contains at least one non-digit character.
        if(num1.length() > 1 && (!num1.matches("^[0-9]+$") || !num2.matches("^[0-9]+$"))) return "-1";

     /*
    You would accomplish adding two very large numbers with the
    above method using BigInteger. But what this is really doing is
    whown in the method below. See https://stackoverflow.com/questions/53274293/how-to-add-two-very-large-numbers-irrespective-of-their-size-in-java-without-usi
     */
        int i = num1.length();
        int j = num2.length();
        int k = Math.max(i, j) + 1; // room for carryover
        char[] c = new char[k];
        /* /= 10 in decimal will give the carry digit
         i.e. 19/10 = 1 in integer division. */
        for (int digit = 0; k > 0; digit /= 10) {
            if (i > 0) // Are we at start of num1 String?
                // Subtract '0' to get actual numerical value of ASCII equivalent
                // for the character.
                // Start at end (right side) of integer string.
                digit += num1.charAt(--i) - '0'; // digit includes carry from int division in for loop
            if (j > 0)
                digit += num2.charAt(--j) - '0';
            c[--k] = (char) ('0' + digit % 10);  // Array c is sum of num1 and num2.
            // So if digit = (9 + 8) then char in array is 17 % 10 = 7
        }
        for (k = 0; k < c.length - 1 && c[k] == '0'; k++) {/*Skip leading zeroes*/}
        return new String(c, k, c.length - k);
    }
}
