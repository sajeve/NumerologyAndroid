package com.chukobyte.numerology.utils;

import java.util.ArrayList;
import java.util.List;

import com.chukobyte.numerology.PersonalProfile;

public class NameMethods {
	
	BirthdateMethods bm = new BirthdateMethods();
	
	//Used to return String to text view
	public String calculateNameValue(String name, int system, int vowelConsonantsChecked) {
		String[] parts;
		int sum = 0;
		String stringSum;
		String compoundNumber;
		
		//Strips string of vowel or consonant depending on what box is checked.
		if(vowelConsonantsChecked == NumerologyConstants.VOWEL) {
			name = name.replaceAll(NumerologyConstants.CONSONANTS_REGEX, "");
		} else if(vowelConsonantsChecked == NumerologyConstants.CONSONANT) {
			name = name.replaceAll(NumerologyConstants.VOWEL_REGEX, "");
		}
		parts = name.split("(?!^)");
		
		if(system == NumerologyConstants.PYTHAGOREAN_SYSTEM) {
			for(String letter:parts) {
				sum += convertPythagoreanLetter(letter);
			}
			
		} else if(system == NumerologyConstants.CHALDEAN_SYSTEM) {
			for (String letter:parts) {
				sum += convertChaldeanLetter(letter);
			}
			
		}
		compoundNumber = Integer.toString(sum);
		stringSum = Integer.toString(addUntilOneDigit10and11and22(sum));
		return name + "\n" + compoundNumber + "/" + stringSum;
	}
	
	public void calculateNameToProfile(String name, int system) {
		int expressionNumber = calculateSumOfName(name, system, NumerologyConstants.EXPRESSION_NUMBER);
		int motivationNumber = calculateSumOfName(name, system, NumerologyConstants.MOTIVATION_NUMBER); //vowel
		int personalityNumber = calculateSumOfName(name, system, NumerologyConstants.PERSONALITY_NUMBER); //consonants
		PersonalProfile.setExpressionNumber(expressionNumber);
		PersonalProfile.setMotivationNumber(motivationNumber);
		PersonalProfile.setPersonalityNumber(personalityNumber);
	}
	
	public int calculateSumOfName(String name, int system, String type) {
		String[] parts;
		int sum = 0;
		if(type.equals(NumerologyConstants.MOTIVATION_NUMBER)) {
			name = name.replaceAll(NumerologyConstants.CONSONANTS_REGEX, "");
		} else if(type.equals(NumerologyConstants.PERSONALITY_NUMBER)) {
			name = name.replaceAll(NumerologyConstants.VOWEL_REGEX, "");
		}
		parts = name.split("(?!^)");
		
		if(system == NumerologyConstants.PYTHAGOREAN_SYSTEM) {
			for(String letter:parts) {
				sum += convertPythagoreanLetter(letter);
			}
			
		} else if(system == NumerologyConstants.CHALDEAN_SYSTEM) {
			for (String letter:parts) {
				sum += convertChaldeanLetter(letter);
			}
			
		}
		sum = addUntilOneDigit10and11and22(sum); //exceptions for 10, 11 and 22
		return sum;
	}
	
	public int addUntilOneDigit(int number) {
		List<Integer> digits = new ArrayList<Integer>();
		int sum;
		while(number > 9) {
			digits.clear();
			sum = 0;
			bm.collectDigits(number, digits);
			for(int tempNumber:digits) {
				sum += tempNumber;
			}
			number = sum;
		}
		
		return number;
	}
	
	public int addUntilOneDigit11and22(int number) { //exceptions for 11 and 22
		List<Integer> digits = new ArrayList<Integer>();
		int sum;
		while(number > 9 && number != 11 && number != 22) {
			digits.clear();
			sum = 0;
			bm.collectDigits(number, digits);
			for(int tempNumber:digits) {
				sum += tempNumber;
			}
			number = sum;
		}
		
		return number;
	}
	
	public int addUntilOneDigit10and11and22(int number) { //exceptions for 10, 11 and 22
		List<Integer> digits = new ArrayList<Integer>();
		int sum;
		while(number > 11 && number != 22) {
			digits.clear();
			sum = 0;
			bm.collectDigits(number, digits);
			for(int tempNumber:digits) {
				sum += tempNumber;
			}
			number = sum;
		}
		
		return number;
	}
	
	public int convertPythagoreanLetter(String letter) {
		if(letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("j") || letter.equalsIgnoreCase("s")) {
			return 1;
		}
		else if(letter.equalsIgnoreCase("b") || letter.equalsIgnoreCase("k") || letter.equalsIgnoreCase("t")) {
			return 2;
		}
		else if(letter.equalsIgnoreCase("c") || letter.equalsIgnoreCase("l") || letter.equalsIgnoreCase("u")) {
			return 3;
		}
		else if(letter.equalsIgnoreCase("d") || letter.equalsIgnoreCase("m") || letter.equalsIgnoreCase("v")) {
			return 4;
		}
		else if(letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("n") || letter.equalsIgnoreCase("w")) {
			return 5;
		}
		else if(letter.equalsIgnoreCase("f") || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("x")) {
			return 6;
		}
		else if(letter.equalsIgnoreCase("g") || letter.equalsIgnoreCase("p") || letter.equalsIgnoreCase("y")) {
			return 7;
		}
		else if(letter.equalsIgnoreCase("h") || letter.equalsIgnoreCase("q") || letter.equalsIgnoreCase("z")) {
			return 8;
		}
		else if(letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("r")) {
			return 9;
		}
		else {
			return 0;
		}
	}
	
	public int convertChaldeanLetter(String letter) {
		if(letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("j")
				|| letter.equalsIgnoreCase("q") || letter.equalsIgnoreCase("y")) {
			return 1;
		}
		else if(letter.equalsIgnoreCase("b") || letter.equalsIgnoreCase("k") || letter.equalsIgnoreCase("r")) {
			return 2;
		}
		else if(letter.equalsIgnoreCase("c") || letter.equalsIgnoreCase("g") || letter.equalsIgnoreCase("l")
				|| letter.equalsIgnoreCase("s")) {
			return 3;
		}
		else if(letter.equalsIgnoreCase("d") || letter.equalsIgnoreCase("m") || letter.equalsIgnoreCase("t")) {
			return 4;
		}
		else if(letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("h") || letter.equalsIgnoreCase("n")
				|| letter.equalsIgnoreCase("x")) {
			return 5;
		}
		else if(letter.equalsIgnoreCase("u") || letter.equalsIgnoreCase("v") || letter.equalsIgnoreCase("w")) {
			return 6;
		}
		else if(letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("z")) {
			return 7;
		}
		else if(letter.equalsIgnoreCase("f") || letter.equalsIgnoreCase("p")) {
			return 8;
		}
		else {
			return 0;
		}
	}
	
}
