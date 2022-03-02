package com.hcl;

public class InsertionSort {

	public static void main(String[] args) {
		
		/* How would you refactor for numeric type array?
		 Careful! "126" < "76" for example!
		 What is Big(O)?
		 */
		String[] strings = {"Joe", "Sally", "Alice", "Wayne", "Sarah", "Samuel", "Blake", "Carrie"};
		sort(strings);
		for(String element : strings) {
			System.out.println(element);
		}
	}
	
	public static String[] sort(String[] a) {
		
		int len = a.length;
		for (int i = 0; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if(a[j - 1].compareTo(a[j]) > 0) { // How do we chabge for desc. order?
					exch(a, j - 1, j);
				} else 
					break;
			}
		}
		return a;
	}

	private static void exch(String[] a, int i, int j) {
		
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
