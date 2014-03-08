package com.chukobyte.numerology;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.chukobyte.numerology.utils.BirthdateMethods;

public class BirthdateActivity extends Activity {
	
	BirthdateMethods bc = new BirthdateMethods();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_birthdate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void calculateBirthdate(View view) {
		PersonalProfile.setUpdateProfile(true);  //Makes it so Personal Profile can be updated when new
		DatePicker datePicker = (DatePicker) findViewById(R.id.dpMain);
		datePicker.clearFocus();
		TextView resultsText = (TextView) findViewById(R.id.resultsText);
		int day  = datePicker.getDayOfMonth();
        int month= datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        String birthDate = bc.formatNumberForDate(month)+ "/" + bc.formatNumberForDate(day) + "/" +
        		bc.formatNumberForDate(year);
        Integer fullRulingNumber = bc.calculateRulingNumber(birthDate);
        PersonalProfile.setUpdateProfile(false);  //makes it so it don't override Personal Profile's array full of bd digits
        Integer rulingNumber = bc.calculateRulingNumber(fullRulingNumber.toString());
        if(rulingNumber > 11) {
        	rulingNumber = bc.calculateRulingNumber(rulingNumber.toString());
        }
        String results = "Birthdate = " + birthDate + "\nRuling number = " + 
        fullRulingNumber + "/" + rulingNumber;
        resultsText.setText(results);
	}
	
}
