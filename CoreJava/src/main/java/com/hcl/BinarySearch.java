package com.hcl;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {2, 4, 7, 17, 23, 34, 45, 56, 62, 126, 278, 1256};
		int searchKey = 78;
		int srchDone = search(searchKey, arr);
		if(srchDone == -1) 
			System.out.println("Key not found!");
		else 
			System.out.println("Found key " + searchKey);

	}
	
	public static int search(int key, int[] a) {
		return search(key, a, 0, a.length);
	}

	private static int search(int key, int[] a, int lo, int hi) {
		
		if(hi <= lo) return -1;
		int mid = lo + (hi - lo)/2;
		int cmp = a[mid] - key;  // a[mid.compareTo(key) for Strings Careful! - "126" < "62" if Strings
		if(cmp > 0) return search(key, a, lo, mid);
		else if(cmp < 0) return search(key, a, mid + 1, hi);
		else return mid; // found key
	}

}
