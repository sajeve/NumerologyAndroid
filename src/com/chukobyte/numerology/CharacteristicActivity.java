package com.chukobyte.numerology;

import com.chukobyte.numerology.utils.NumerologyConstants;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera.Size;
import android.view.Menu;
import android.widget.TextView;

public class CharacteristicActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_characteristic);
		
		Intent intent = getIntent();
		TextView testTV = (TextView) findViewById(R.id.testTV);
		String result;
		//If from Birthdate Activity
		if(intent.getStringExtra(NumerologyConstants.CHARACTERISTIC).equals(NumerologyConstants.BIRTHDATE)) {
		int rulingNumber = intent.getIntExtra(NumerologyConstants.RULING_NUMBER, 0);
		int dayNumber = intent.getIntExtra(NumerologyConstants.DAY_NUMBER, 0);
		result = "Ruling Number = " + rulingNumber + "\nDay Number = " + dayNumber;
		} else if (intent.getStringExtra(NumerologyConstants.CHARACTERISTIC).equals(NumerologyConstants.NAME)) {
			int expressionNumber = intent.getIntExtra(NumerologyConstants.EXPRESSION_NUMBER, 0);
			int personalityNumber = intent.getIntExtra(NumerologyConstants.PERSONALITY_NUMBER, 0);
			int motivatonNumber = intent.getIntExtra(NumerologyConstants.MOTIVATION_NUMBER, 0);
			result = "Expression Number = " + expressionNumber + "\nPersonality Number = " + personalityNumber + 
					"\nMotivation Number = " + motivatonNumber;
		} else {
			result = "Error!";
		}
		
		testTV.setText(result);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
