package com.hcl.solid;

public class Rectangle {
	
	private Double length;
	private Double width;
	
	
	
	public Rectangle(Double length, Double width) {
		
		this.length = length;
		this.width = width;
	}

	Double calcArea() {
		
		return length*width;
	}

}
