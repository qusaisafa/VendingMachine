package com.vendingmachine.exception;


public class NotProperCoinException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotProperCoinException() {
		super("Coin not accepted");
	}
	
}
