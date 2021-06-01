package com.hcl.condiments;

import com.hcl.drinks.Beverage;

public class Nuts extends CondimentDecorator {

	private Beverage beverage;
	
	public Nuts(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		
		return 0.50 + beverage.cost();
	}
	
	public String getDescription() {
		
		return beverage.getDescription() + ", mixed nuts";
	}

}
