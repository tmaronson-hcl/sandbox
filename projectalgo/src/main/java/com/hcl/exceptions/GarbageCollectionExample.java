package com.hcl.exceptions;

public class GarbageCollectionExample {

	public static void main(String[] args) {

		GarbageCollectionExample t1 = new GarbageCollectionExample();
		GarbageCollectionExample t2 = new GarbageCollectionExample();
		t1 = null; // What happens if not null and not eligible for GC both t1 and t2?
		System.gc();
		t2 = null;
		Runtime.getRuntime().gc();
	}

	@Override
	protected void finalize() throws Throwable {  // Check function of finalize method!
		System.out.println("Garbage collector called");
		System.out.println("Object garbage collected " + this);
	}
	
	

}
