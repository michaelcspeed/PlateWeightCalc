package com.speed.platecalc;

import android.app.ActionBar;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class WeightPreferencesActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		ActionBar ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new PrefsFragment()).commit();
	}

}