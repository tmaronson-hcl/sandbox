package com.hcl.solid;

public class ShapeDriver {

	public static void main(String[] args) {

		Rectangle rect = new Square(5.0);
		Rectangle rect2 = new Rectangle(6.0, 9.0);
		System.out.format("%.1f %.1f", rect.calcArea(), rect2.calcArea());
		calcArea(rect);
	}

	private static void calcArea(Rectangle re) { // This example with variations show violation of Liskov.

		// already calculated area but this was added
	}

	/* When/if you see the standard rectangle/square example of Liskov SP be aware of the setters and what they 
	 * are doing, may not be the greatest example of how to code this example.
	 * What is the point? The point is do not base inheritance on properties BUT behavior. i.e. state/properties
	 * and not methods.
	 */
}
