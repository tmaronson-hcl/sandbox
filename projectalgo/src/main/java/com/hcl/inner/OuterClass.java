package com.hcl.inner;

class OuterClass {

	private int i = 6;

	static class StaticInner {

		private int j = 1;

		void print() {

			System.out.println("Another print method but in static class");
		}

		static void printStatic() {
			System.out.println("static method here");
		}
	}

	public static void main(String[] args) {

		new StaticInner().print(); // access non-static method
		StaticInner.printStatic();  // access static method
		new OutsideClass().genMethod();
	}

}

class OutsideClass {

	void genMethod() {
		OuterClass.StaticInner.printStatic(); //  access static method in an outside class
	}
}
