package com.speed.platecalc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.preferences);
		register();
	}

	private void register() {
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		register();
		setDefaultWeightHint();
	}
	

	private void setDefaultWeightHint() {
		findPreference("custom_set").setSummary(getPreferenceScreen().getSharedPreferences().getString("custom_set", "None")); 
		findPreference("default_bar_weight").setSummary(getPreferenceScreen().getSharedPreferences().getString("default_bar_weight", "20")); 
		
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		
		if(getPreferenceScreen().getSharedPreferences().getString("default_bar_weight", "").equals("")){
			SharedPreferences.Editor e = getPreferenceScreen().getSharedPreferences().edit();
			e.putString("default_bar_weight", "0");
			e.commit();
		}
		
		setDefaultWeightHint();
		
	}

}