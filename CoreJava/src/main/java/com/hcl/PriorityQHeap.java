package com.hcl;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

// heapsort
public class PriorityQHeap {
	
	// Could move main method to another class as the client/tester.
	public static void main(String[] args) {

		new PriorityQHeap().heapify();
	}

	private void heapify() {
		
		// Constructor takes a Comparator interface type
		// We will get to lambdas -> and functinal programming later.
		PriorityQueue<Integer> pqMin = new PriorityQueue<>((a, b) -> a - b);
		PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> b - a);
		pqMin.add(27);
		pqMin.add(21);
		pqMin.add(4);
		pqMin.add(45);
		pqMin.add(35);
		pqMin.add(23);
		pqMin.add(19);
		pqMin.add(5);
		pqMin.add(22);
		pqMin.add(42);
		
		pqMax.addAll(pqMin); // same values here
		reHeapify(pqMin, pqMax);
	}

	private void printResults(List<Integer> valuesAsc, List<Integer> valuesDesc) {
		
		System.out.println("Increasing value:" + valuesAsc);
		System.out.println("Decreasing value:" + valuesDesc);
	}

	private void reHeapify(PriorityQueue<Integer> pqMin, PriorityQueue<Integer> pqMax) {
				
		List<Integer> valuesAsc = new ArrayList<>();
		List<Integer> valuesDesc = new ArrayList<>();
		while(!pqMin.isEmpty()) {
			valuesAsc.add(pqMin.poll());
		}
		while(!pqMax.isEmpty()) {
			valuesDesc.add(pqMax.poll());
		}
		printResults(valuesAsc, valuesDesc);
	}

}