package com.vendingmachine.app;

import java.util.Random;

import com.vendingmachine.exception.NoCoinsInsertedException;
import com.vendingmachine.model.Code;
import com.vendingmachine.model.Coin;
import com.vendingmachine.model.Notes;
import com.vendingmachine.model.Snack;
import com.vendingmachine.service.CoinService;
import com.vendingmachine.service.SnackService;

public class VendingMachineImp implements VendingMachineInterface {

    // CoinService, SnackService : singleton classes to allow making only one instance of each
	
	public VendingMachineImp() {
		initilaizer();
	}
	
    // Initialize vending machine with default snacks and default prices from 1 to 100 dollar
	private void initilaizer() {
		CoinService.getInstance().setMoneyStorege(100);
		Random randomNum = new Random();
		int max = 100;
		int min = 1;
		int price = 0;
		for(Code code: Code.values()) {
			price = min + randomNum.nextInt(max);
			SnackService.getInstance().addSnack(new Snack(null, code, price));
			SnackService.getInstance().addSnack(new Snack(null, code, price));

		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vendingmachine.app.VendingMachineInterface#insertCoins(com.vendingmachine.model.Coin)
	 * insert coins to machine and save it on insertedMoney variable as total in dollar
	 */
	@Override
	public void insertCoins(Coin coins) {
		CoinService.getInstance().addInsertedMoney(coins.getCoinDolar());
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.vendingmachine.app.VendingMachineInterface#insertCard(com.vendingmachine.model.Code)
	 * insert card and cash out snack price from it 
	 */
	@Override
	public void insertCard(Code code) {
		Snack snack = SnackService.getInstance().getSnackByCode(code);
		CoinService.getInstance().addInsertedMoney(snack.getPrice());
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.vendingmachine.app.VendingMachineInterface#insertNotes(com.vendingmachine.model.Notes)
	 *  insert Notes and save it on insertedMoney variable as total in dollar
	 */
	@Override
	public void insertNotes(Notes notes) {
		CoinService.getInstance().addInsertedMoney(notes.getNotesDolar());
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.vendingmachine.app.VendingMachineInterface#cancelAndReturnMoney()
	 *  cancel buy process and return money to user
	 */
	@Override
	public double cancelAndReturnMoney() {
		
		double money = CoinService.getInstance().getMoneyInserted();
		CoinService.getInstance().setMoneyInserted(0);
		
		return money;
	}
	/*
	 *  function to calculate money that should be returned to user after
	 *  purchasing and cash out 
	 */
	public double moneyBack(Snack snack, double money) {
		double moneyBack = money - snack.getPrice();
		if(moneyBack > 0) {
			return moneyBack;
		}
		
		return 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.vendingmachine.app.VendingMachineInterface#pickupSnackReturnExtraMoney(com.vendingmachine.model.Code)
	 * pickup Snack and cash out from inserted money
	 * will clear inserted money variable after cash out and returning money back 
	 * @exceptions : not enough money inserted 
	 * @return : double value of many back amount to user
	 */
	@Override
	public double pickupSnackReturnExtraMoney(Code code) {
		
		double moneyInserted = CoinService.getInstance().getMoneyInserted();
		
		if(moneyInserted == 0) {
			throw new NoCoinsInsertedException();
		}
		
		Snack snack = SnackService.getInstance().getSnackByCode(code);
		
		if(snack.getPrice() > moneyInserted) {
			throw new NoCoinsInsertedException(snack.getPrice() - moneyInserted);
		}
		
		if(SnackService.getInstance().buySnack(snack)) {
			CoinService.getInstance().addMoneyToStorege(snack.getPrice()); // add money equal to snack price to machine storege
			CoinService.getInstance().setMoneyInserted(0); // return the extra money and set user money storege(inserted money) to zero
			return moneyBack(snack, moneyInserted);
		}
		
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	
}
