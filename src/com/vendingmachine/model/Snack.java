package com.vendingmachine.model;

public class Snack {

	// snack name can be null
	private String name;
	
	/*
	 *  code defines depending on snack location on machine(rowcolumn) 
	 *  example :C1 item on third row first column
	 */
	private Code code;
	
	// snack price in dollar currency
	private float price;
	
	public Snack() {
		
	}
	
	public Snack(String name, Code code, float price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
