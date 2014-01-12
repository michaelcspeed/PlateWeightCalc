package com.speed.platecalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class BeforeFragment extends Fragment implements TextWatcher {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	private EditText input;
	float weight = 0;

	public BeforeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.before_fragment, container,
				false);

		input = (EditText) rootView.findViewById(R.id.weightInput);
		input.addTextChangedListener(this);
		return rootView;
	}

	@Override
	public void afterTextChanged(Editable arg0) {
		weight = Float.valueOf(input.getText().toString());
		Log.i("plate", input.getText().toString());

		calculate();
	}

	private void calculate() {
		if (weight != 0)

			Log.i("plate", "weight in half is " + weight / 2);

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub

	}
}