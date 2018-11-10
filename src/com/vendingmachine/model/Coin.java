package com.vendingmachine.model;

/*
 *  Coin enum defines 4 accepted types of Dollar currency 
 *  @C10 : 10Cents 
 *  @C20 : 20Cents
 *  @C50 : 50Cents
 *  DOLLAR : 1Dollar
 */
public enum Coin {
	 C10(0.10), C20(0.20), C50(0.50), DOLLAR(1);
	
	private double coinDolar;
	
	private Coin(double coinDolar) {
		this.coinDolar = coinDolar;
	}

	public double getCoinDolar() {
		return coinDolar;
	}

}
