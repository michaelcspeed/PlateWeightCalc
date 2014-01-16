package com.speed.platecalc;

//

import java.util.ArrayList;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BeforeFragment extends Fragment implements TextWatcher,
		OnClickListener {

	private LinearLayout holder;
	private EditText weightEditText;
	private EditText barEditText;
	private int barWeight = 0;
	private SharedPreferences mySharedPreferences;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		View rootView = inflater.inflate(R.layout.before_fragment, container,
				false);

		mySharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getActivity());

		holder = (LinearLayout) rootView.findViewById(R.id.holder);
		weightEditText = (EditText) rootView.findViewById(R.id.weightEnter);
		weightEditText.addTextChangedListener(this);
		barEditText = (EditText) rootView.findViewById(R.id.barEnter);
		barEditText.addTextChangedListener(this);
		return rootView;
	}

	private void createViews(ArrayList<Double> weights) {

		boolean colouredWeights = mySharedPreferences.getBoolean(
				"coloured_weights", false);

		for (int i = 0; i < weights.size(); i++) {
			if (weights.get(i) == 25) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(133, 900));
				a25.setImageDrawable(getResources().getDrawable(R.drawable.red));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("25");
				;
			}
			if (weights.get(i) == 20) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(133, 900));
				a25.setImageDrawable(getResources()
						.getDrawable(R.drawable.blue));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("20");
			}
			if (weights.get(i) == 15) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(100, 900));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.yellow));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("15");
			}
			if (weights.get(i) == 10) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(100, 900));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.green));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("10");
			}
			if (weights.get(i) == 5) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(100, 800));
				if (colouredWeights)
					a25.setImageDrawable(getResources().getDrawable(
							R.drawable.red5));
				else
					a25.setImageDrawable(getResources().getDrawable(
							R.drawable.black5));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("5");
			}
			if (weights.get(i) == 2.5) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(50, 400));
				if (colouredWeights)
					a25.setImageDrawable(getResources().getDrawable(
							R.drawable.blue2p5));
				else
					a25.setImageDrawable(getResources().getDrawable(
							R.drawable.black2p5));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("2.5");
			}
			if (weights.get(i) == 1.25) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(40, 300));
				if (colouredWeights)
					a25.setImageDrawable(getResources().getDrawable(
							R.drawable.yellow1p25));
				else
					a25.setImageDrawable(getResources().getDrawable(
							R.drawable.black1p25));
				holder.addView(a25);
				a25.setOnClickListener(this);
				a25.setTag("1.25");
			}

		}

	}

	private ArrayList<Double> calculateWeights(double weightToLift,
			int barWeight) {

		Log.i("Weights", "Weight to lift: " + weightToLift);

		weightToLift -= barWeight;
		weightToLift /= 2;

		ArrayList<Double> weights = new ArrayList<Double>();

		while (weightToLift > 0) {
			if (weightToLift >= 25) {
				weights.add((double) 25);
				Log.i("Weights", "Added 25kg");
				weightToLift -= 25;
			} else if (weightToLift >= 20) {
				weights.add((double) 20);
				Log.i("Weights", "Added 20kg");
				weightToLift -= 20;
			} else if (weightToLift >= 15) {
				weights.add((double) 15);
				Log.i("Weights", "Added 15kg");
				weightToLift -= 15;
			} else if (weightToLift >= 10) {
				weights.add((double) 10);
				Log.i("Weights", "Added 10kg");
				weightToLift -= 10;
			} else if (weightToLift >= 5) {
				weights.add((double) 5);
				Log.i("Weights", "Added 5kg");
				weightToLift -= 5;
			} else if (weightToLift >= 2.5) {
				weights.add(2.5);
				Log.i("Weights", "Added 2.5kg");
				weightToLift -= 2.5;
			} else if (weightToLift >= 1.25) {
				weights.add(1.25);
				Log.i("Weights", "Added 1.25kg");
				weightToLift -= 1.25;
			} else
				break;

		}

		return weights;

	}

	@Override
	public void afterTextChanged(Editable s) {

		updateWeightImages();

	}

	private void updateWeightImages() {

		String barWeight;
		int barWeightNumber;
		double liftWeightNumber;

		// Let's not be ridiculous

		holder.removeAllViews();

		if (barEditText.getText().toString().compareTo("") == 0)
			barWeight = mySharedPreferences
					.getString("default_bar_weight", "0");
		else {
			barWeight = barEditText.getText().toString();
		}

		barWeightNumber = Integer.parseInt(barWeight);

		if (weightEditText.getText().toString().compareTo("") == 0)
			liftWeightNumber = 0;
		else
			liftWeightNumber = Double.parseDouble(weightEditText.getText()
					.toString());

		ArrayList<Double> aL = calculateWeights(liftWeightNumber,
				barWeightNumber);

		createViews(aL);

		aL.clear();
	}

	@Override
	public void onResume() {
		super.onResume();
		updateWeightImages();
		barEditText.setHint("Bar Weight ("
				+ mySharedPreferences.getString("default_bar_weight", "0")
				+ "kg)");
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(getActivity(), v.getTag().toString(), Toast.LENGTH_SHORT)
				.show();
	}

}