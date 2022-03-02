package com.hcl;

/******************************************************************************
*  Compilation:  javac Quick.java
*  Execution:    java Quick < input.txt
*  Dependencies: StdOut.java StdIn.java
*  Data files:   https://algs4.cs.princeton.edu/23quicksort/tiny.txt
*                https://algs4.cs.princeton.edu/23quicksort/words3.txt
*
*  Sorts a sequence of strings from standard input using quicksort.
*   
*  % more tiny.txt
*  S O R T E X A M P L E
*
*  % java Quick < tiny.txt
*  A E E L M O P R S T X                 [ one string per line ]
*
*  % more words3.txt
*  bed bug dad yes zoo ... all bad yet
*       
*  % java Quick < words3.txt
*  all bad bed bug dad ... yes yet zoo    [ one string per line ]
*
*
*  Remark: For a type-safe version that uses static generics, see
*
*    https://algs4.cs.princeton.edu/23quicksort/QuickPedantic.java
*
******************************************************************************/

/**
 * The {@code Quick} class provides static methods for sorting an array and
 * selecting the ith smallest element in an array using quicksort.
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/23quicksort">Section 2.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * @author Tom Aronson
 */
public class Quick {

	// This class should not be instantiated.
	private Quick() {
	}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		
		sort(a, 0, a.length - 1);
		
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v)) {
				if (i == hi)
					break;
			}

			// find item on hi to swap
			while (less(v, a[--j])) {
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel
			}

			// check if pointers cross
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		if (v == w)
			return false; // optimization when reference equals
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void main(String[] args) {

		String[] strings = { "Joe", "Sally", "Alice", "Wayne", "Sarah", "Samuel", "Blake", "Carrie" };
		Quick.sort(strings, 0, strings.length - 1);
		for (String element : strings)
			System.out.println(element);

	}

}

/*
 * public class QuickSortBug {
 * 
 * public static void main(String[] args) {
 * 
 * String[] strings = {"Joe", "Sally", "Alice", "Wayne", "Sarah", "Samuel",
 * "Blake", "Carrie"}; quickSort(strings, 0, strings.length - 1); for(String
 * element : strings) System.out.println(element); }
 * 
 * static void quickSort(String[] a, int left, int right) { if (right <= left)
 * return; int i = partition(a, left, right); quickSort(a, left, i - 1);
 * quickSort(a, i + 1, right); }
 * 
 * private static int partition(String[] a, int left, int right) {
 * 
 * int i = left - 1, j = right; String v = a[right]; // pivot element for (;;) {
 * System.out.println("j = " + j); //while (a[++i].compareTo(v) < 0); while
 * (less(a[++i], v)); while (less(v, a[j--])) { if (j == 1) break; } if (i >= j)
 * break; exch(a, i, j); } exch(a, i, right); return i; }
 * 
 * private static void exch(String[] a, int i, int j) {
 * 
 * String t = a[i]; a[i] = a[j]; a[j] = t; }
 * 
 * private static boolean less(Comparable v, Comparable w) { return
 * v.compareTo(w) < 0; } }
 */