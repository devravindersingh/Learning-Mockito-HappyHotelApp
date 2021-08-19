package com.mockitotutorial.happyhotel.booking;

public class CurrencyConverter {

	private static final double USD_TO_EUR_RATE = 0.85;
	
	public static double toEuro(double dollarAmount) {
		return dollarAmount * USD_TO_EUR_RATE; 
	}
	
}
