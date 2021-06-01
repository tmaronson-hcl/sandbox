package com.hcl.condiments;

import com.hcl.drinks.Beverage;

public abstract class CondimentDecorator extends Beverage {

	// want abstract methods here
	public abstract String getDescription();
	public abstract double cost();

}
