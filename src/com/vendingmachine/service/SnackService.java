package com.vendingmachine.service;

import java.util.ArrayList;
import java.util.List;

import com.vendingmachine.exception.SnackNotFoundException;
import com.vendingmachine.model.Code;
import com.vendingmachine.model.Snack;

//Singleton class since we need only one instance 
public class SnackService {
	
	 private static final SnackService instance = new SnackService();
	    
    // private constructor to avoid client applications to use constructor
    private SnackService(){}

    public static SnackService getInstance(){
        return instance;
    }

	private List<Snack> snackList = new ArrayList<>();
	
	public void addSnack(Snack snack) {
		snackList.add(snack);
	}
	
	/*
	 * check if machine have snacks with an code
	 * @code : two character string represent snack item location on the machine
	 * @code example : A1 means the item in the first row and first column
	 */
	
	public Snack getSnackByCode(Code code) {
		for(Snack snack:snackList) {
			if(snack.getCode() == code) {
				return snack;
			}
		}
		throw new SnackNotFoundException(code);
	}
	
	// find number of items in the same column which have the same code
	public int getNumberOfSnacks(Code code) {
		int numberOfSnacks = 0;
		for(Snack snack:snackList) {
			if(snack.getCode() == code) {
				numberOfSnacks++;
			}
		}
		return numberOfSnacks;
	}
	
	// buy snack and remove it from the available snacks list
	public boolean buySnack(Snack snack) {
		
		if(snack == null)
			return false;
		
		snackList.remove(snack); // remove snack from the list
		return true;
	}

	public List<Snack> getSnackList() {
		return snackList;
	}

	public void setSnackList(List<Snack> snackList) {
		this.snackList = snackList;
	}
	
}
