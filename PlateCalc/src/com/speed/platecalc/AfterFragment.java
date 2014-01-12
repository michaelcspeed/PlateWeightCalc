package com.speed.platecalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AfterFragment extends Fragment implements OnClickListener {
	private Button minusPlus1P25;
	private EditText weightCount1P25;
	private Button buttonPlus1P25;
	private Button minusPlus2P5;
	private EditText weightCount2P5;
	private Button buttonPlus2P5;
	private Button minusPlus5;
	private EditText weightCount5;
	private Button buttonPlus5;
	private Button minusPlus10;
	private EditText weightCount10;
	private Button buttonPlus10;
	private Button minusPlus15;
	private EditText weightCount15;
	private Button buttonPlus15;
	private Button minusPlus20;
	private EditText weightCount20;
	private Button buttonPlus20;
	private View rootView;
	private TextView resultText;

	int count1P25 = 0;
	int count2P5 = 0;
	int count10 = 0;
	int count15 = 0;
	int count20 = 0;
	int count5 = 0;
	private Button clearButton;

	/**
	 * Find the Views in the layout<br />
	 * <br />
	 * Auto-created on 2014-01-06 20:31:29 by Android Layout Finder
	 * (http://www.buzzingandroid.com/tools/android-layout-finder)
	 */
	private void findViews() {
		minusPlus1P25 = (Button) rootView.findViewById(R.id.minusPlus1P25);
		weightCount1P25 = (EditText) rootView
				.findViewById(R.id.weightCount1P25);
		buttonPlus1P25 = (Button) rootView.findViewById(R.id.buttonPlus1P25);
		minusPlus2P5 = (Button) rootView.findViewById(R.id.minusPlus2P5);
		weightCount2P5 = (EditText) rootView.findViewById(R.id.weightCount2P5);
		buttonPlus2P5 = (Button) rootView.findViewById(R.id.buttonPlus2P5);
		minusPlus5 = (Button) rootView.findViewById(R.id.minusPlus5);
		weightCount5 = (EditText) rootView.findViewById(R.id.weightCount5);
		buttonPlus5 = (Button) rootView.findViewById(R.id.buttonPlus5);
		minusPlus10 = (Button) rootView.findViewById(R.id.minusPlus10);
		weightCount10 = (EditText) rootView.findViewById(R.id.weightCount10);
		buttonPlus10 = (Button) rootView.findViewById(R.id.buttonPlus10);
		minusPlus15 = (Button) rootView.findViewById(R.id.minusPlus15);
		weightCount15 = (EditText) rootView.findViewById(R.id.weightCount15);
		buttonPlus15 = (Button) rootView.findViewById(R.id.buttonPlus15);
		minusPlus20 = (Button) rootView.findViewById(R.id.minusPlus20);
		weightCount20 = (EditText) rootView.findViewById(R.id.weightCount20);
		buttonPlus20 = (Button) rootView.findViewById(R.id.buttonPlus20);
		resultText = (TextView) rootView.findViewById(R.id.result);
		clearButton = (Button) rootView.findViewById(R.id.clearButton); 

		minusPlus1P25.setOnClickListener(this);
		buttonPlus1P25.setOnClickListener(this);
		minusPlus2P5.setOnClickListener(this);
		buttonPlus2P5.setOnClickListener(this);
		minusPlus5.setOnClickListener(this);
		buttonPlus5.setOnClickListener(this);
		minusPlus10.setOnClickListener(this);
		buttonPlus10.setOnClickListener(this);
		minusPlus15.setOnClickListener(this);
		buttonPlus15.setOnClickListener(this);
		minusPlus20.setOnClickListener(this);
		buttonPlus20.setOnClickListener(this);
		clearButton.setOnClickListener(this);
	}

	/**
	 * Handle button click events<br />
	 * <br />
	 * Auto-created on 2014-01-06 20:31:29 by Android Layout Finder
	 * (http://www.buzzingandroid.com/tools/android-layout-finder)
	 */
	@Override
	public void onClick(View v) {
		if (v == minusPlus1P25) {
			// Handle clicks for minusPlus1P25
			if (count1P25 != 0)
				count1P25--;
			weightCount1P25.setText(String.valueOf(count1P25));
		} else if (v == buttonPlus1P25) {
			// Handle clicks for buttonPlus1P25
			count1P25++;
			weightCount1P25.setText(String.valueOf(count1P25));
		} else if (v == minusPlus2P5) {
			// Handle clicks for minusPlus2P5
			if (count2P5 != 0)
				count2P5--;
			weightCount2P5.setText(String.valueOf(count2P5));
		} else if (v == buttonPlus2P5) {
			// Handle clicks for buttonPlus2P5
			count2P5++;
			weightCount2P5.setText(String.valueOf(count2P5));
		} else if (v == minusPlus5) {
			// Handle clicks for minusPlus5
			if (count5 != 0)
				count5--;
			weightCount5.setText(String.valueOf(count5));
		} else if (v == buttonPlus5) {
			// Handle clicks for buttonPlus5
			count5++;
			weightCount5.setText(String.valueOf(count5));
		} else if (v == minusPlus10) {
			// Handle clicks for minusPlus10
			if (count10 != 0)
				count10--;
			weightCount10.setText(String.valueOf(count10));
		} else if (v == buttonPlus10) {
			// Handle clicks for buttonPlus10
			count10++;
			weightCount10.setText(String.valueOf(count10));
		} else if (v == minusPlus15) {
			// Handle clicks for minusPlus15
			if (count15 != 0)
				count15--;
			weightCount15.setText(String.valueOf(count15));
		} else if (v == buttonPlus15) {
			// Handle clicks for buttonPlus15
			count15++;
			weightCount15.setText(String.valueOf(count15));
		} else if (v == minusPlus20) {
			// Handle clicks for minusPlus20
			if (count20 != 0)
				count20--;
			weightCount20.setText(String.valueOf(count20));
		} else if (v == buttonPlus20) {
			// Handle clicks for buttonPlus20
			count20++;
			weightCount20.setText(String.valueOf(count20));
		}
		else if(v == clearButton) {
			weightCount10.setText("");
			weightCount15.setText("");
			weightCount1P25.setText("");
			weightCount20.setText("");
			weightCount2P5.setText("");
			weightCount5.setText("");
			count10 = 0;
			count15 = 0;
			count1P25 = 0;
			count20 = 0;
			count2P5  = 0;
			count5 = 0;
		}

		updateResult();
	}

	private void updateResult() {
		double result = (10 * count10) + (15 * count15) + (1.25 * count1P25)
				+ (20 * count20) + (2.5 * count2P5) + (5 * count5);
		resultText.setText(String.valueOf(result) + "kg");
	}

	public AfterFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.after_fragment, container, false);

		findViews();
		return rootView;
	}
}