package com.vendingmachine.exception;

import com.vendingmachine.model.Code;

public class SnackNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SnackNotFoundException(Code code) {
		super("no snacks items exist of code "+code);
	}
	
}
