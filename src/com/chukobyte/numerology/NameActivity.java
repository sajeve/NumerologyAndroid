package com.chukobyte.numerology;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.chukobyte.numerology.utils.NameMethods;
import com.chukobyte.numerology.utils.NumerologyConstants;

public class NameActivity extends Activity {
	
	NameMethods nm = new NameMethods();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_name);
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
		RadioGroup systemRG = (RadioGroup) findViewById(R.id.nameSystemRG);
		RadioGroup vowelConsonantRG = (RadioGroup) findViewById(R.id.vowelConsonantRG);
		String results;
		int selectedSystemId = systemRG.getCheckedRadioButtonId();
		int selectedVowelConsonantId = vowelConsonantRG.getCheckedRadioButtonId();
		
		if(selectedSystemId == R.id.pythagoreanRB) {
			results = nm.calculateNameValue(nameText.getText().toString(), NumerologyConstants.PYTHAGOREAN_SYSTEM, selectedVowelConsonantId);
		} else if (selectedSystemId == R.id.chaldeanRB) {
			results = nm.calculateNameValue(nameText.getText().toString(), NumerologyConstants.CHALDEAN_SYSTEM, selectedVowelConsonantId);
		} else {
			results = "Error!";
		}
		
		resultsTV.setText(results);
	}

}
