package com.hcl;

import java.util.Scanner;

/*
This class has more than one responsibility now so not good.
Could create another class that is not public in this file
or try create another class file. But this is minor as it is a demo.
 */
public class NotMuch {

    public static void main(String[] args) {

        Person p1 = new Person("Joe", 160, "M", 72);
        Person p2 = new Person("Joe", 160, "M", 72);
        Person p3 = new Person("Josephine", 122, "F", 65);
        System.out.printf("Values for p1, p2, p3: %s, %s, %s\n", p1, p2, p3);

        String result =  p1.equals(p2) ? "equal Persons" : "not equal Persons";
        String result2 = p2.equals(p3) ? "equal Persons" : "not equal Persons";
        System.out.printf("The results are\n %s\n %s\n", result, result2);

        NotMuch nm = new NotMuch();
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number for primes: ");
        if(sc.hasNextInt()) {
           num = sc.nextInt();
            nm.numPrimeNumbers(num);
        } else {
            System.err.println("Illegal number - ending for now!");
        }

    }

    private void numPrimeNumbers(int num) {

        int primes = 0;
        int i = 0;
        outer: for(i = 3; i <= num; i +=2) {
            for(int j = 3; j < i; j += 2) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            primes += 1;
            System.out.printf("%d ", i);
        }
        System.out.printf("\nNumber of prime numbers up to %d is %d", num, primes);
    }
}
