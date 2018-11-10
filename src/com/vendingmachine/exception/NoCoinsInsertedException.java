package com.vendingmachine.exception;

public class NoCoinsInsertedException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoCoinsInsertedException() {
		super("no coins inserted ");
	}
	public NoCoinsInsertedException(double coins) {
		super("please insert "+coins+"$ and choose the item again");
	}
}
