package com.vendingmachine.app;

import com.vendingmachine.model.Code;
import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Notes;

public interface SnackMachineInterface {
	
	// accept 10c, 20c, 50c, 1$
	public void insertCoins(Coin coins);
	
	// accept all cards , it will purchase from card depending on snack exact price
	public void insertCard(Code code);
	
	// accept 20$, 50$
	public void insertNotes(Notes notes);
	
	// return money if canceled 
	public double cancelAndReturnMoney();
	
	// buy snack and return extra money
	public double pickupSnackReturnExtraMoney(Code code); 
	
	// reset machine by admin
	public void reset();
	

}
