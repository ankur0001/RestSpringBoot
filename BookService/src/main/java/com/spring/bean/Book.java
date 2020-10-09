package com.spring.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Book {

	@NotNull(message="Id should not be null")
	private int id;
	
	private String category;
	
	@Min(value=0, message="Price should not be Negative")
	private int price;
	
	public Book(int id, String category, int price) {
		super();
		this.id = id;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
