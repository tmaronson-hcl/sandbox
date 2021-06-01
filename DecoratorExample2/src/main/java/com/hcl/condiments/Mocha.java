package com.hcl.condiments;

import com.hcl.drinks.Beverage;

public class Mocha extends CondimentDecorator {

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public double cost() {
		
		return 0.20 + beverage.cost();
	}
	
	public String getDescription() {
		
		return beverage.getDescription() + " Mocha";
	}

}
