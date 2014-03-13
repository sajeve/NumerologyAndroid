package com.chukobyte.numerology;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.chukobyte.numerology.utils.NameMethods;
import com.chukobyte.numerology.utils.NumerologyConstants;

public class NameActivity extends Activity {
	
	NameMethods nm = new NameMethods();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);
		
		PersonalProfile.resetProfile();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.name, menu);
		return true;
	}
	
	public void calculateName(View view) {
		EditText nameText = (EditText) findViewById(R.id.nameET);
		TextView resultsTV = (TextView) findViewById(R.id.resultsTV);
		//Numerology System Spinner
		Spinner systemSpinner = (Spinner) findViewById(R.id.system_spinner);
		int selectedSystemId = (int) systemSpinner.getSelectedItemPosition();
		ArrayAdapter<CharSequence> systemAdapter = ArrayAdapter.createFromResource(this,
		        R.array.system_array, android.R.layout.simple_spinner_item);
		systemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		systemSpinner.setAdapter(systemAdapter);
		//Vowel Consonant Spinner
		Spinner vowelConsonantSpinner = (Spinner) findViewById(R.id.vowelconsonants_spinner);
		int selectedVowelConsonantId = (int) vowelConsonantSpinner.getSelectedItemPosition();
		ArrayAdapter<CharSequence> vowelConsonantAdapter = ArrayAdapter.createFromResource(this,
		        R.array.vowelconsonant_array, android.R.layout.simple_spinner_item);
		vowelConsonantAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		vowelConsonantSpinner.setAdapter(vowelConsonantAdapter);
		String results;
		
		if(selectedSystemId == NumerologyConstants.PYTHAGOREAN_SYSTEM) {
			results = nm.calculateNameValue(nameText.getText().toString(), NumerologyConstants.PYTHAGOREAN_SYSTEM, selectedVowelConsonantId);
		} else if (selectedSystemId == NumerologyConstants.CHALDEAN_SYSTEM) {
			results = nm.calculateNameValue(nameText.getText().toString(), NumerologyConstants.CHALDEAN_SYSTEM, selectedVowelConsonantId);
		} else {
			results = "Error!";
		}
		
		resultsTV.setText(results);
	}
	
	public void characteristicClick(View view) {
//		Intent intent = new Intent(this, ResultsActivity.class);
//		intent.putExtra(NumerologyConstants.EXPRESSION_NUMBER, PersonalProfile.getExpressionNumber());
//		intent.putExtra(NumerologyConstants.PERSONALITY_NUMBER, PersonalProfile.getPersonalityNumber());
//		intent.putExtra(NumerologyConstants.MOTIVATION_NUMBER, PersonalProfile.getMotivationNumber());
//		startActivity(intent);
	}

}
