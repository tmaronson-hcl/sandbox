package com.hcl.algos;

import java.util.HashSet;
import java.util.Set;

public class CustomerDriver {

	public static void main(String[] args) {
		
		Customer cust1 = new Customer("DrinkA");
		Customer cust2 = new Customer("DrinkA");
		Customer cust3 = new Customer("DrinkB");
		Customer cust4 = new Customer("DrinkC");
		Customer cust5 = new Customer("DrinkD");
		Customer cust6 = new Customer("DrinkB");
		Customer cust7 = new Customer("DrinkE");
		Customer[] customers = { cust1, cust2, cust3, cust4, cust5, cust6, cust7 };
		Set<Integer> indexes = new CustomerDriver().moreThanOne(customers);
		Set<Integer> indexes2 = new CustomerDriver().getDuplicates(customers);
		System.out.println(indexes);
		System.out.println(indexes2);

	}
	
	private void init() {
		
	}

	
	public Set<Integer> moreThanOne(Customer[] customers) {
		// Return the index of the customer in the customer array if their drink has
		// been ordered more than one time
		Set<Integer> duplicates = new HashSet<>();
		for (int i = 0; i < customers.length; i++) {
			for (int j = 1; j < customers.length; j++) {
				if (customers[i].drink.equals(customers[j].drink) && i != j) {
					// duplicate element found
					duplicates.add(i);
					duplicates.add(j);
					break;
				}
			}
		}
		return duplicates;
	}

	// This will only capture last duplicate element of each drink.
	public Set<Integer> getDuplicates(Customer[] customers) {
		Set<String> drinks = new HashSet<>();
		Set<Integer> drinksInds = new HashSet<>();
		for (int i = 0; i < customers.length; i++) {
			if (!drinks.add(customers[i].drink)) {
				drinksInds.add(i);
			}
		}
		return drinksInds;
	}

}
