package com.hcl.inher;

import java.time.LocalDateTime;

public abstract class BankAccount {

	private String owner;
	double balance = 0.0;

	public BankAccount(String owner, double balance) {
		this.owner = owner;
		this.balance = balance;
	}

	void deposit(double amount) {

		if (amount >= 0) {
			balance += amount;
		} else {
			System.out.println("Invalid Amount");
		}
	}

	double getBalance() {
		return balance;
	}

	abstract void withdrawal(double amount);
}

class CheckingAccount extends BankAccount {

	// Could be declared in different way.
	public final double INSUFFICIENT_FUNDS_FEE = 25;

	public CheckingAccount(String owner, double balance) {
		super(owner, balance);
	}

	@Override
	void withdrawal(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient Funds");
			System.out.println("Fee of " + INSUFFICIENT_FUNDS_FEE 
					+ " will be charged to your account.");
			balance -= INSUFFICIENT_FUNDS_FEE;
		} else {
			balance -= amount;
		}
	}

	void processCheck(String check) {

		System.out.println("stub - add process check logic later " 
				+ "when get direction from product owner.");
	}
}

class SavingsAccount extends BankAccount {

	// Could be declared in different way.
	public final double ANNUAL_INTEREST_RATE = 1.1;

	public SavingsAccount(String owner, double balance) {
		super(owner, balance);
		/*
		 * Just showing how method below works. Would not 
		 * necessarily call the method in constructor but
		 * just once per month so there is no duplication of interest.
		 */
		depositMonthlyInterest();
	}

	@Override
	void withdrawal(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient Funds");
		} else {
			balance -= amount;
		}
	}

	// Want to later determine other ways this method should be called.
	boolean depositMonthlyInterest() {

		//LocalDateTime now = LocalDateTime.now();
		// Could test end of month with below.
		LocalDateTime now = LocalDateTime.of(2021, 7, 31, 0, 0);//now();
		int monthVal = now.getMonth().getValue();
		int monthValTomorrow = now.plusDays(1).getMonthValue();
		if (monthVal != monthValTomorrow) {
			balance += balance*ANNUAL_INTEREST_RATE/(12*100);
			System.out.println("Wow - we added monthly interest to your account!");
			return true;
		}
		return false;
	}
}
