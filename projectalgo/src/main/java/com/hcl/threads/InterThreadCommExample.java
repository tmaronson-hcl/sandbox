package com.hcl.threads;



class InterThreadCommExample {
	
	public static void main(String[] args) {
		
		InterThreadComm e1 = new InterThreadComm();
		ItcEven e2 = new ItcEven(e1);
		ItcOdd e3 = new ItcOdd(e1);
		e2.start();
		e3.start();
	}

}
