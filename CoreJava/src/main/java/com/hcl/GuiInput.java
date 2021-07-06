package com.hcl;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class GuiInput {

    public static void main(String[] args) {
        new ScannerInput ().input (); // call input method in class ScannerInput
        float gallons = Float.parseFloat(JOptionPane.showInputDialog(null,
                "Enter gallons used", "Gas Mileage",
                JOptionPane.WARNING_MESSAGE));
        float miles = Float.parseFloat(JOptionPane.showInputDialog(null,
                "Enter miles traveled", "Miles",
                JOptionPane.WARNING_MESSAGE));
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);

        JOptionPane.showMessageDialog(null, nf.format(miles/gallons),
                "Mileage is below",  JOptionPane.INFORMATION_MESSAGE);
        System.out.printf("Your mileage in mpg is %6.2f\n", miles/gallons);
        Varargs va = new Varargs();
        va.processNums(56.2, 56.6, 5.44);
    }
}

class Varargs {
    double sum = 0;
    void processNums(double ... nums) {
        for(double f : nums ) {
            sum += f;
        }
        System.out.printf("The sum is %5.2f", sum);
    }

}

class ScannerInput {

    private Scanner scanner;

    ScannerInput() {
        scanner = new Scanner(System.in);
    }

    void input() {
        double miles = 0, gallons = 0;

        /*
        1. ASSUME user will not make an error.
        2. The user can give erroneous input (typo).  validation
        3. Yes, but what happens if user makes a series of typos?  loop
        Another way to get infinite loop with a for loop?
        for(;  ;)
         */

        while (true) {
            System.out.print("Please enter miles ");
            if (scanner.hasNextDouble ()) {  // check token
                miles = scanner.nextDouble ();
                break;  // good token so break out of loop
            }
           scanner.next (); // get rid of crummy token
        }
        while (true) {
            System.out.print ("Please enter gallons used ");
            if (scanner.hasNextDouble ()) {
                gallons = scanner.nextDouble ();
                break;
            }
            scanner.next ();
        }
        scanner.close ();
        System.out.printf("Mileage is %7.2f\n", miles/gallons);
        System.exit (0);
    }
}
