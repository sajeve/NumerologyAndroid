package com.chukobyte.numerology.utils;

public class NumerologyConstants {
	
	public static final String RULING_NUMBER = "RULING_NUMBER";
	public static final String DAY_NUMBER = "DAY_NUMBER";
	public static final String EXPRESSION_NUMBER = "EXPRESSION_NUMBER";
	public static final String PERSONALITY_NUMBER = "PERSONALITY_NUMBER";
	public static final String MOTIVATION_NUMBER = "MOTIVATION_NUMBER";
	
	//Used for selecting the system to calculate name
	public static final int PYTHAGOREAN_SYSTEM = 0;
	public static final int CHALDEAN_SYSTEM = 1;
	
	//Constants for Vowel and Consonants
	public static final int WHOLE = 0;
	public static final int VOWEL = 1;
	public static final int CONSONANT = 2;
	
	//Regex for vowels and consonants
	public static final String VOWEL_REGEX = "[aeiouAEIOU]";
	public static final String CONSONANTS_REGEX = "[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]";
	

}
