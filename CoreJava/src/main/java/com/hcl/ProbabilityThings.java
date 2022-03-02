package com.hcl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class ProbabilityThings {

	public static void main(String[] args) {
		
		// new ScannerInput ().input (); // call input method in class ScannerInput
		int trials = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Enter number of trials", "Games", JOptionPane.WARNING_MESSAGE));
		new ProbabilityThings().figureOddsCoinTosses(trials);
		
		
		/*
		 * 
		 * System.out.printf("Your mileage in mpg is %6.2f\n", miles/gallons);
		 */
		// Varargs va = new Varargs();
		// va.processNums(56.2, 56.6, 5.44);
	}

	private void figureOddsCoinTosses(int trials) {
		
		Map<Integer, List<Integer>> mapRands = new Random().ints(trials, 0, 2).boxed()
				.collect(Collectors.groupingBy(Integer::intValue));
		List<List<Integer>> vals = new ArrayList<>(mapRands.values());
		int heads = vals.get(0).size();
		int tails = vals.get(1).size();
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMaximumFractionDigits(1);
		double pctHeads = 100.0*heads/(heads + tails);
		String strHeads = nf.format(pctHeads);
		JOptionPane.showMessageDialog(null, "heads: " + heads
				+ "\ntails: " + tails + "\n% heads = " 
				+ pctHeads,
				"Results are shown below",
				JOptionPane.INFORMATION_MESSAGE);

		System.out.printf("heads: %d tails: %d\n", heads, tails);
		long h = new Random().ints(trials, 0, 2)
							 .boxed()
							 .count();
		System.out.println("count = " + h);

	}
}

class ScannerInput2 {

	private Scanner scanner;

	ScannerInput2() {
		scanner = new Scanner(System.in);
	}

}
