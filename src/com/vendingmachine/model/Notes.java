package com.vendingmachine.model;
/*
 *  Notes Enum defines two types of Dollar notes
 *  @N20 : 20 dollar
 *  @N50 : 50 Dollar
 */
public enum Notes {
	N20(20), N50(50);
	
	private double notesDolar;
	
	private Notes(double notesDolar) {
		this.notesDolar = notesDolar;
	}

	public double getNotesDolar() {
		return notesDolar;
	}
}
