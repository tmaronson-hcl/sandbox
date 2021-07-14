package com.hcl.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ExercisesI {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = list
				.stream()
				.filter(value -> value % 2 != 0)
				.reduce(0, Integer::sum);
		System.out.println(sum);

		Long num = list
				.stream()
				.filter(value -> value % 2 != 0)
				.count(); // sum()
		System.out.println(num);

		Random random = new Random();
		random.ints(1000000, 1, 3).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((side, frequency) -> System.out.printf("%-6d%d%n", side, frequency));
		random.ints(1000000, 1, 11).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((side, frequency) -> System.out.print(String.format("%-6d%d%n", side, frequency)));

		slider();

	}

	private static void slider() {

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("ChangeEvent is " + e);

			}
		});

		slider.addChangeListener((e) -> System.out.println("ChangeEvent is " + e));
		
		
	}

}
