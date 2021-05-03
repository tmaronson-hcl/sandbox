package com.hcl.inher;

class ParentClass implements Printable {
	
	private int count;
	
	ParentClass() {
		System.out.println("Constructor of parent class");
	}
	
	ParentClass(int count) {
		this.count = count;
	}
	
	public static void main(String args[]) {
		SubClass obj = new SubClass();
	}

	@Override
	public void print() {

		System.out.println("This will print something good later.");
	}
}

class SubClass extends ParentClass {
	SubClass() {
		//super();
		System.out.println("Constructor of child class");
	}
	
	@Override // protecting us at compile time - Do you have the correct behavior?
	public String toString() {
		return "stub to be filled later";
	}

	

}