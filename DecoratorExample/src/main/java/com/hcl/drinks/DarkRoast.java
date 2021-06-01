package com.hcl.drinks;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		
		description = "Most Excellent Dark Roast";
	}
	@Override
	public double cost() {
		
		return 1.99;
	}
}
