package com.hcl.inher;

public class ThreadInner {

	public static void main(String[] args) {

		// from docs - Thread class has overloaded ctor that takes type Runnable
		Thread t1 = new Thread(new Runnable() { // anonymous inner class - class has no name
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		t1.start(); // start thread that will call run method		
				
	}

}
