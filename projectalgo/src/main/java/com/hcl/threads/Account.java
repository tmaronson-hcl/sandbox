package com.hcl.threads;

class Account {

	private int balance;

	public Account() {
		balance = 5000;
	}

	// What happens if not synchronized method or object? What is better?
	public void withdraw(int bal) {

		synchronized (this) {

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		balance -= bal;
		System.out.println("Balance remaining:::" + balance + " " + Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException {

		Account acct1 = new Account();
		Bank bank = new Bank(acct1);
		Thread t1 = new Thread(bank, "thread1");
		Thread t2 = new Thread(bank, "thread2");
		Thread t3 = new Thread(bank, "thread3");
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		
	}

}

class Bank implements Runnable {

	Account obj;

	public Bank(Account obj) {

		this.obj = obj;
	}

	@Override
	public void run() {

		obj.withdraw(500);

	}
}


