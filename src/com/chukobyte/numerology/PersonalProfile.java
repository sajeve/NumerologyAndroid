package com.chukobyte.numerology;

import java.util.ArrayList;
import java.util.List;

public class PersonalProfile {
	
	//Static class that stores all information about one person
	
	private static List<Integer> digits = new ArrayList<Integer>();
	private static boolean updateProfile = true;
	
	//-1 is default for number not set
	//birthdate related
	private static int rulingNumber;
	private static int dayNumber;
	
	//name related
	private static int expressionNumber;
	private static int personalityNumber;
	private static int motivationNumber;
	
	public static void resetProfile() {
		setRulingNumber(-1);
		setDayNumber(-1);
		setExpressionNumber(-1);
		setPersonalityNumber(-1);
		setMotivationNumber(-1);
	}

	public static List<Integer> getDigits() {
		return digits;
	}

	public static void setDigits(List<Integer> digits) {
		PersonalProfile.digits = digits;
	}

	public static boolean isUpdateProfile() {
		return updateProfile;
	}

	public static void setUpdateProfile(boolean updateProfile) {
		PersonalProfile.updateProfile = updateProfile;
	}

	public static int getRulingNumber() {
		return rulingNumber;
	}

	public static void setRulingNumber(int rulingNumber) {
		PersonalProfile.rulingNumber = rulingNumber;
	}

	public static int getDayNumber() {
		return dayNumber;
	}

	public static void setDayNumber(int dayNumber) {
		PersonalProfile.dayNumber = dayNumber;
	}

	public static int getExpressionNumber() {
		return expressionNumber;
	}

	public static void setExpressionNumber(int expressionNumber) {
		PersonalProfile.expressionNumber = expressionNumber;
	}

	public static int getPersonalityNumber() {
		return personalityNumber;
	}

	public static void setPersonalityNumber(int personalityNumber) {
		PersonalProfile.personalityNumber = personalityNumber;
	}

	public static int getMotivationNumber() {
		return motivationNumber;
	}

	public static void setMotivationNumber(int motivationNumber) {
		PersonalProfile.motivationNumber = motivationNumber;
	}
	
	
	
	
	
	

}
