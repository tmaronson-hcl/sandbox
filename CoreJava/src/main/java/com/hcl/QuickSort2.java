package com.hcl;

public class QuickSort2 {

	/*s
	 *  General object case could be used with 
	 *  small amount of refactoring.
	 *  Purpose of partition method in quicksort is the 
	 *  pivot point should be at correct sorted position.
	 *  All elements less than pivot are then placed before
	 *  pivot. It follows that all elements greater than
	 *  pivot will be placed after pivot.
	 
	 */
	int partition(Object[] arr, int low, int high) {
		Object pivot = arr[high];
		int i = low - 1; // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (less(arr[j], pivot)) {
				i++;
				// swap arr[i] and arr[j]
				swap(arr, i, j);
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		swap(arr, i + 1, high);
		return i + 1;
	}

	/*
	 * The main function that implements 
	 * QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void sort(Object[] arr, int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, 
			 * arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	/* A utility function to print array of size n */
	void printArray(Object[] arr) {
		for (Object element : arr)
			System.out.printf("%s ", element);
		System.out.println();
	}
	
	// swap method
	private static void swap(Object[] a, int i, int j) {

		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	// comparison method
	private boolean less(Object arr, Object pivot) {
		
		// Prevent ClassCastException for String and Integer types.
		if(pivot instanceof String)
			return 
				((String) arr).compareTo((String) pivot) <= 0;
		else
			return 
				((Integer) arr).compareTo((Integer) pivot) <= 0;
 
	}

// Driver program - could be in separate class file.
	public static void main(String args[]) {
		Integer arrInt[] = { 10, 7, 8, 9, 1, 5 };
		String[] arrStr = {"Joe", "Sally", 
				"Alice", "Wayne", "Sarah", "Samuel", "Blake", "Carrie"};
		int n = arrInt.length;
		int s = arrStr.length;

		QuickSort2 ob = new QuickSort2();
		ob.sort(arrInt, 0, n - 1);
		ob.sort(arrStr, 0, s - 1);
		ob.printArray(arrInt);
		ob.printArray(arrStr);
	}
}

/* This code is contributed by Rajat Mishra and others
 * as QuickSort is just QuickSort, right? 
 * but there are many revisions by Tom Aronson */
