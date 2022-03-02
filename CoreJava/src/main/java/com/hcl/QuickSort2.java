package com.hcl;

public class QuickSort2 {

	/*s
	 *  General object case could be used with 
	 *  small amount refactoring.
	 *  Purpose of partition method in quicksort is the 
	 *  pivot point should be at correct sorted position.
	 *  All elements less than pivot are then placed before
	 *  pivot. It follows that all elements greater than
	 *  pivot will be placed after pivot.
	 
	 */
	int partition(String[] arr, int low, int high) {
		String pivot = arr[high];
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
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	void sort(String[] arr, int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	/* A utility function to print array of size n */
	void printArray(String arr[]) {
		for (String element : arr)
			System.out.printf("%s ", element);
		System.out.println();
	}
	
	// swap method
	private static void swap(String[] a, int i, int j) {

		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	// comparison method
	private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

// Driver program - could be in separate class file.
	public static void main(String args[]) {
		//int arr[] = { 10, 7, 8, 9, 1, 5 };
		String[] arr = {"Joe", "Sally", 
				"Alice", "Wayne", "Sarah", "Samuel", "Blake", "Carrie"};
		int n = arr.length;

		QuickSort2 ob = new QuickSort2();
		ob.sort(arr, 0, n - 1);
		ob.printArray(arr);
	}
}

/* This code is contributed by Rajat Mishra but a lot of revisions by Tom Aronson */
