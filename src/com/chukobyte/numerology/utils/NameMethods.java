package com.chukobyte.numerology.utils;

import java.util.ArrayList;
import java.util.List;

import com.chukobyte.numerology.R;

public class NameMethods {
	
	BirthdateMethods bm = new BirthdateMethods();
	
	public String calculateNameValue(String name, int system, int vowelConsonantsChecked) { //add parameter for vowel/consonant distinction
		String[] parts;
		int sum = 0;
		String stringSum;
		String compoundNumber;
		
		//Strips string of vowel or consonant depending on what box is checked.
		if(vowelConsonantsChecked == R.id.vowelRB) {
			name = name.replaceAll(NumerologyConstants.CONSONANTS_REGEX, "");
		} else if(vowelConsonantsChecked == R.id.consonantRB) {
			name = name.replaceAll(NumerologyConstants.VOWEL_REGEX, "");
		}
		parts = name.split("(?!^)");
		
		if(system == NumerologyConstants.PYTHAGOREAN_SYSTEM) {
			for(String letter:parts) {
				sum += convertPythagoreanLetter(letter);
			}
			//another
			
		} else if(system == NumerologyConstants.CHALDEAN_SYSTEM) {
			for (String letter:parts) {
				sum += convertChaldeanLetter(letter);
			}
			//another
			
		}
		compoundNumber = Integer.toString(sum);
		stringSum = Integer.toString(addUntilOneDigit(sum));
		return name + "\n" + compoundNumber + "/" + stringSum;
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
	
	public boolean isVowel(String letter) {
		if(letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i") 
				|| letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) {
			return true;
		} else {
			return false;
		}
	}
	
	//to do
	//make method to determine if y is a vowel
	public boolean isVowel(String letter, boolean isYAVowel) {
		if(letter.equalsIgnoreCase("y") && isYAVowel) {
			return true;
		} else {
			return isVowel(letter);
		}
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
	
}
