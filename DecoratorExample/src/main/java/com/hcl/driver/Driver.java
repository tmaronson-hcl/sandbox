package com.hcl.driver;

import java.text.NumberFormat;

import com.hcl.condiments.CondimentDecorator;
import com.hcl.condiments.Milk;
import com.hcl.condiments.Mocha;
import com.hcl.condiments.Nuts;
import com.hcl.drinks.Beverage;
import com.hcl.drinks.DarkRoast;
import com.hcl.drinks.Espresso;

public class Driver {

	public static void main(String[] args) {

		Beverage bev1 = new DarkRoast();
		Beverage bev2 = new Espresso();
		Beverage condDec1 = new Mocha(new Milk(bev1)); // ?  IO
		Beverage condDec2 = new Mocha(new Milk(new Nuts(bev2)));
		System.out.format("%s $%.2f\n",condDec1.getDescription(), condDec1.cost());
		System.out.format("%s $%.2f",condDec2.getDescription(), condDec2.cost());
		
	}

}
