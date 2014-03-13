package com.chukobyte.numerology.utils;

import java.util.ArrayList;
import java.util.List;

import com.chukobyte.numerology.PersonalProfile;

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
	
	public int calculateSumOfNumbers(String birthDate) {
		List<Integer> digits = new ArrayList<Integer>();
		int bd = Integer.parseInt(birthDate.replace("/", ""));
		int sum = 0;
		collectDigits(bd, digits);
		for(int number:digits) {
			sum += number;
		}
		
//		if(PersonalProfile.isUpdateProfile()) { //Give array of digits to Personal Profile
//	    	PersonalProfile.setDigits(digits);
//	    }
		
		return sum;
	}
	
	
	public void collectDigits(int num, List<Integer> digits) {
	    if(num / 10 > 0) {
	        collectDigits(num / 10, digits);
	    }
	    digits.add(num % 10);
	}

}
