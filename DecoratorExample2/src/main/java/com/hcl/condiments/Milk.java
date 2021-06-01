package com.hcl.condiments;

import com.hcl.drinks.Beverage;

public class Milk extends CondimentDecorator {

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		
		return 0.10 + beverage.cost();
	}
	
	public String getDescription() {
		
		return beverage.getDescription() + ", Milk";
	}

}
