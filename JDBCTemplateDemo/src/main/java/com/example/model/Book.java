package com.example.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private Long id;
	private String name;
	private BigDecimal price;
	
	
	public Book(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	

}
