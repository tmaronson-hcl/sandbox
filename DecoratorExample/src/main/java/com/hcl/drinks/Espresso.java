package com.hcl.drinks;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Very fine Espresso";
	}
	@Override
	public double cost() {
		
		return 2.10;
	}

}
