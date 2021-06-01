package com.hcl.condiments;

import com.hcl.drinks.Beverage;

public abstract class CondimentDecorator extends Beverage {

	protected Beverage beverage; // Refactor (pull up) from condiments to superclass here
	
	// want abstract methods here
	public abstract String getDescription();
	public abstract double cost();

}
