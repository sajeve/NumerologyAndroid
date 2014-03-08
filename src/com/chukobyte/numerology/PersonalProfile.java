package com.chukobyte.numerology;

import java.util.ArrayList;
import java.util.List;

public class PersonalProfile {
	
	//Static class that stores all information about one person
	
	private static List<Integer> digits = new ArrayList<Integer>();
	private static boolean updateProfile = true;

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
	
	
	
	

}
