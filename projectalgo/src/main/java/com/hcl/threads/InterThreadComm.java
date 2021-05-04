package com.hcl.threads;

public class InterThreadComm {

	boolean flag = false;

	synchronized void even() {

		for (int i = 2; i <= 10; i++) {
			if (!flag) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (i % 2 == 0) {
				System.out.println(i + "-even-");
			}
			flag = false;
			notify();
		}
	}

	synchronized void odd() {

		for (int i = 2; i <= 10; i++) {
			if (flag) {
				try {
					wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (i % 2 != 0) {
				System.out.println(i + "-odd-");
			}
			flag = true;
			notify();
		}
	}

}

class ItcEven extends Thread {

	private InterThreadComm no;

	public ItcEven(InterThreadComm no) {
		this.no = no;
	}

	@Override
	public void run() {

		no.even();
	}
}

class ItcOdd extends Thread {

	private InterThreadComm no;

	public ItcOdd(InterThreadComm no) {
		this.no = no;
	}

	@Override
	public void run() {

		no.odd();
	}
}
