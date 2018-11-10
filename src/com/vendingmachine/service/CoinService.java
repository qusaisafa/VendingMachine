package com.vendingmachine.service;


// Singleton class since we need only one instance 
public class CoinService {

	 private static final CoinService instance = new CoinService();
	    
    // private constructor to avoid client applications to use constructor
    private CoinService(){}

    public static CoinService getInstance(){
        return instance;
    }
    
	private double moneyStorege = 0 ;
	
	private double moneyInserted = 0;
	
	public void addMoneyToStorege(double money) {
		this.moneyStorege += money;
	}
	
	public void addInsertedMoney(double money) {
		this.moneyInserted += money;
	}

	public double getMoneyStorege() {
		return moneyStorege;
	}

	public void setMoneyStorege(double moneyStorege) {
		this.moneyStorege = moneyStorege;
	}

	public double getMoneyInserted() {
		return moneyInserted;
	}

	public void setMoneyInserted(double moneyInserted) {
		this.moneyInserted = moneyInserted;
	}
	
	
}
