package com.hcl.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise6 {

	public static void main(String[] args) {
		Invoice[] invoices = { new Invoice("83", "Electric sander", 7, 57.98),
				new Invoice("24", "Power saw", 18, 99.99), new Invoice("7", "Sledge hammer", 11, 21.50),
				new Invoice("77", "Hammer", 76, 11.99), new Invoice("39", "Lawn mower", 3, 79.50),
				new Invoice("68", "Screwdriver", 106, 6.99), new Invoice("56", "Jig saw", 21, 11.00),
				new Invoice("3", "Wrench", 34, 7.50) };
		List<Invoice> invoiceArr = Arrays.asList(invoices);

		// Exercise 6.1
		List<Invoice> sortedInvoices = invoiceArr.stream().sorted(Comparator.comparing(Invoice::getPartDescription))
				.collect(Collectors.toList());
		sortedInvoices.forEach((obj) -> System.out.println(obj.toString()));

		// Exercise 6.2
		System.out.println("\n");
		List<Invoice> sortInvoices2 = invoiceArr.stream().sorted(Comparator.comparing(Invoice::getPricePerItem))
				.collect(Collectors.toList());
		sortInvoices2.forEach((obj) -> System.out.println(obj.toString()));

		// Exercise 6.3
		System.out.println("\n");
		Map<Integer, String> mapInvoicesMap = invoiceArr.stream().collect(
				Collectors.toMap(obj -> obj.getQuantity(), obj -> obj.getPartDescription(), (o1, o2) -> o1 + ";" + o2));
		System.out.println(mapInvoicesMap);

		Map sorted = mapInvoicesMap.entrySet().stream()
				// .sorted(Map.Entry.comparingByKey()) // need this method for LinkedHashMap
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, TreeMap::new));
		System.out.println(sorted);

	}

	static class Invoice {
		private String partNumber;
		private String partDescription;
		private int quantity;
		private Double pricePerItem;

		public Invoice(String partNumber, String partDescription, int quantity, Double pricePerItem) {
			// TODO Auto-generated constructor stub
			this.partNumber = partNumber;
			this.partDescription = partDescription;
			this.quantity = quantity;
			this.pricePerItem = pricePerItem;
		}

		@Override
		public String toString() {
			return String.format("%s %s %s  %s", this.partNumber, this.partDescription, this.quantity,
					this.pricePerItem);
		}

		public String getPartDescription() {
			return partDescription;
		}

		public Double getPricePerItem() {
			return pricePerItem;
		}

		public int getQuantity() {
			return quantity;
		}
	}

}
