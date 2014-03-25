package com.chukobyte.numerology.utils;

import java.util.ArrayList;
import java.util.List;

public class BirthdateMethods {
	
	public String formatNumberForDate(int number) {
		String numberText = null;
		if(number <= 9) {
			numberText = "0" + number;
		} else {
			numberText = Integer.toString(number);
		}
		return numberText;
	}
	
	public int calculateSumOfNumbersCompoundRulingNumber(String birthDate) {
		List<Integer> digits = new ArrayList<Integer>();
		int bd = Integer.parseInt(birthDate.replace("/", ""));
		int sum = 0;
		collectDigits(bd, digits);
		for(int number:digits) {
			sum += number;
		}
		
		return sum;
	}
	
	public int addUntilOneDigitRulingNumber(int number) { //exceptions for 11 and 22
		List<Integer> digits = new ArrayList<Integer>();
		int sum;
		while(number > 11 && number != 22) {
			digits.clear();
			sum = 0;
			collectDigits(number, digits);
			for(int tempNumber:digits) {
				sum += tempNumber;
			}
			number = sum;
		}
		
		return number;
	}
	
	public int addUntilOneDigitDayNumber(int number) {
		List<Integer> digits = new ArrayList<Integer>();
		int sum;
		while(number > 9) {
			digits.clear();
			sum = 0;
			collectDigits(number, digits);
			for(int tempNumber:digits) {
				sum += tempNumber;
			}
			number = sum;
		}
		
		return number;
	}
	
	
	public void collectDigits(int num, List<Integer> digits) {
	    if(num / 10 > 0) {
	        collectDigits(num / 10, digits);
	    }
	    digits.add(num % 10);
	}

}
