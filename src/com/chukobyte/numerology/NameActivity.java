package com.chukobyte.numerology;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.chukobyte.numerology.utils.NameMethods;
import com.chukobyte.numerology.utils.NumerologyConstants;

public class NameActivity extends Activity {

	NameMethods nm = new NameMethods();

	EditText nameText;
	TextView resultsTV;
	TextView characteristicText;
	Spinner systemSpinner;
	int selectedSystemId;
	ArrayAdapter<CharSequence> systemAdapter;
	Spinner vowelConsonantSpinner;
	int selectedVowelConsonantId;
	ArrayAdapter<CharSequence> vowelConsonantAdapter;
	StringBuilder sbResults = new StringBuilder();
	StringBuilder sbName = new StringBuilder();

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
		nameText = (EditText) findViewById(R.id.nameET);
		resultsTV = (TextView) findViewById(R.id.resultsTV);
		characteristicText = (TextView) findViewById(R.id.characteristicsTVName);
		// Numerology System Spinner
		systemSpinner = (Spinner) findViewById(R.id.system_spinner);
		selectedSystemId = (int) systemSpinner.getSelectedItemPosition();
		systemAdapter = ArrayAdapter.createFromResource(this,
				R.array.system_array, android.R.layout.simple_spinner_item);
		systemAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Vowel Consonant Spinner
		vowelConsonantSpinner = (Spinner) findViewById(R.id.vowelconsonants_spinner);
		selectedVowelConsonantId = (int) vowelConsonantSpinner
				.getSelectedItemPosition();
		vowelConsonantAdapter = ArrayAdapter.createFromResource(this,
				R.array.vowelconsonant_array,
				android.R.layout.simple_spinner_item);
		vowelConsonantAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		if(sbName.length() > 0) {
			sbName.setLength(0);
		}
		if(sbResults.length() > 0) {
			sbResults.setLength(0);
		}
		sbName.append(nameText.getText().toString());
		sbResults.append(nm.calculateNameValue(sbName.toString(),
				selectedSystemId, selectedVowelConsonantId));
		nm.calculateNameToProfile(sbName.toString(), selectedSystemId);
		// Setting clickable TextView
		if (PersonalProfile.getExpressionNumber() > 1) { // if there is a value
															// for names
			characteristicText.setClickable(true);
			characteristicText.setTextColor(Color.BLUE);
			// characteristicText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
			characteristicText.setText("Click here to view characteristics");
			resultsTV.setText(sbResults.toString());
		} else {
			Toast toast = Toast.makeText(this, "Enter a name!",
					Toast.LENGTH_SHORT);
			toast.show();
		}

	}

	public void characteristicClick(View view) {
		Intent intent = new Intent(this, CharacteristicActivity.class);
		intent.putExtra(NumerologyConstants.CHARACTERISTIC,
				NumerologyConstants.NAME);
		intent.putExtra(NumerologyConstants.EXPRESSION_NUMBER,
				PersonalProfile.getExpressionNumber());
		intent.putExtra(NumerologyConstants.PERSONALITY_NUMBER,
				PersonalProfile.getPersonalityNumber());
		intent.putExtra(NumerologyConstants.MOTIVATION_NUMBER,
				PersonalProfile.getMotivationNumber());
		startActivity(intent);
	}

}
