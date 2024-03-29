package com.chukobyte.numerology;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	public static String PACKAGE_NAME;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PACKAGE_NAME = getApplicationContext().getPackageName();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void goToBirthdateActivity(View view) {
		Intent intent = new Intent(this, BirthdateActivity.class);
		startActivity(intent);
	}
	
	public void goToNameActivity(View view) {
		Intent intent = new Intent(this, NameActivity.class);
		startActivity(intent);
	}

}
