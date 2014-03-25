package com.chukobyte.numerology;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.chukobyte.numerology.utils.BirthdateMethods;
import com.chukobyte.numerology.utils.NumerologyConstants;

public class BirthdateActivity extends Activity {
	
	BirthdateMethods bc = new BirthdateMethods();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_birthdate);
		
		PersonalProfile.resetProfile();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void calculateBirthdate(View view) {
		TextView characteristicText = (TextView) findViewById(R.id.characteristicsTVBirthDate);
//		PersonalProfile.setUpdateProfile(true);  //Makes it so Personal Profile can be updated when new
		DatePicker datePicker = (DatePicker) findViewById(R.id.dpMain);
		datePicker.clearFocus();
		TextView resultsText = (TextView) findViewById(R.id.resultsText);
		Integer day  = datePicker.getDayOfMonth();
        Integer month= datePicker.getMonth() + 1;
        Integer year = datePicker.getYear();
        String birthDate = bc.formatNumberForDate(month)+ "/" + bc.formatNumberForDate(day) + "/" +
        		bc.formatNumberForDate(year);
        Integer fullRulingNumber = bc.calculateSumOfNumbersCompoundRulingNumber(birthDate);
//        PersonalProfile.setUpdateProfile(false);  //makes it so it don't override Personal Profile's array full of bd digits
//        Integer stringRulingNumber = bc.calculateSumOfNumbersCompoundRulingNumber(fullRulingNumber.toString());
        Integer rulingNumber = bc.addUntilOneDigitRulingNumber(fullRulingNumber);
        
        //for Personal Profile
        PersonalProfile.setRulingNumber(rulingNumber);
        PersonalProfile.setDayNumber(bc.addUntilOneDigitDayNumber(day));
        
        characteristicText.setClickable(true);
        characteristicText.setTextColor(Color.BLUE);
        characteristicText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        characteristicText.setText("Click here to view characteristics");
        String results = "Birthdate = " + birthDate + "\nRuling number = " + 
        fullRulingNumber + "/" + rulingNumber;
        resultsText.setText(results);
	}
	
	public void characteristicClick(View view) {
		Intent intent = new Intent(this, CharacteristicActivity.class);
		intent.putExtra(NumerologyConstants.CHARACTERISTIC, NumerologyConstants.BIRTHDATE);
		intent.putExtra(NumerologyConstants.RULING_NUMBER, PersonalProfile.getRulingNumber()); //todo add ruling number from PersonalProfile
		intent.putExtra(NumerologyConstants.DAY_NUMBER, PersonalProfile.getDayNumber()); //todo add day number from PersonalProfile
		startActivity(intent);
	}
	
}
