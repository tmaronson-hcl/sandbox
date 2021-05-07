package com.hcl.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateTimeJava8 {

	public static void main(String[] args) {
		
		new DateTimeJava8().show();
	}

	private void show() {
		
		LocalDate date = LocalDate.now();
		LocalDate prev1 = LocalDate.of(2018, 01, 31);
		LocalDate prev2 = LocalDate.parse("2018-01-31");
		System.out.printf("Those dates are %s %s %s%n"
				, date, prev1, prev2);
		DayOfWeek day = LocalDate.parse("2012-06-01")
				.getDayOfWeek();
		LocalDate other = LocalDate.now().minus(2, ChronoUnit.DAYS);
		
		
	}

}
