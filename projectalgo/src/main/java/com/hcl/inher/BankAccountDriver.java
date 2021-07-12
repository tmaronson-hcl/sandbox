package com.hcl.inher;

public class BankAccountDriver {

	public static void main(String[] args) {
		
		BankAccount ca1 = new CheckingAccount("Joseph Blow", 100.00);
		ca1.deposit(25.00);
		ca1.deposit(50.00);
		ca1.withdrawal(60.00);
		System.out.printf("ca1 bal. is $%.2f\n", ca1.getBalance());
		
		BankAccount ca2 = new CheckingAccount("Sarah Miles", 1000.00);
		ca2.deposit(35.00);
		ca2.deposit(60.00);
		ca2.withdrawal(1175.00);
		System.out.printf("ca2 bal. is $%.2f\n", ca2.getBalance());
		String.format("String format $%.2f\n", ca2.getBalance());
		
		BankAccount sa1 = new SavingsAccount("Joseph Blow", 100.00);
		sa1.deposit(35.00);
		sa1.deposit(60.00);
		sa1.withdrawal(115.00);
		System.out.printf("sa1 bal. is $%.2f\n", sa1.getBalance());

	}

}
