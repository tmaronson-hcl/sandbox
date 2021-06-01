package com.hcl.drinks;

public abstract class Beverage {
	
	protected String description = "Unknown Beverage";
	
	public abstract double cost();
	
	public String getDescription() {
		return description;
	}
	
	
	

}


