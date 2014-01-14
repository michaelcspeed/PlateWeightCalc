package com.speed.platecalc;

//

import java.util.ArrayList;

import android.os.Bundle;
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

public class BeforeFragment extends Fragment implements TextWatcher,
		OnClickListener {

	private LinearLayout holder;
	private EditText weightEditText;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		View rootView = inflater.inflate(R.layout.before_fragment, container,
				false);

		holder = (LinearLayout) rootView.findViewById(R.id.holder);
		weightEditText = (EditText) rootView.findViewById(R.id.weightEnter);
		weightEditText.addTextChangedListener(this);
		return rootView;
	}

	private void createViews(ArrayList<Double> weights) {

		for (int i = 0; i < weights.size(); i++) {
			if (weights.get(i) == 25) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(133, 900));
				a25.setImageDrawable(getResources().getDrawable(R.drawable.red));
				holder.addView(a25);
				a25.setOnClickListener(this);
			}
			if (weights.get(i) == 20) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(133, 900));
				a25.setImageDrawable(getResources()
						.getDrawable(R.drawable.blue));
				holder.addView(a25);
				a25.setOnClickListener(this);
			}
			if (weights.get(i) == 15) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(100, 900));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.yellow));
				holder.addView(a25);
				a25.setOnClickListener(this);
			}
			if (weights.get(i) == 10) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(100, 900));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.green));
				holder.addView(a25);
				a25.setOnClickListener(this);
			}
			if (weights.get(i) == 5) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(100, 800));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.black5));
				holder.addView(a25);
				a25.setOnClickListener(this);
			}
			if (weights.get(i) == 2.5) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(50, 400));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.black2p5));
				holder.addView(a25);
				a25.setOnClickListener(this);
			}
			if (weights.get(i) == 1.25) {
				ImageView a25 = new ImageView(getActivity());
				a25.setLayoutParams(new LayoutParams(40, 300));
				a25.setImageDrawable(getResources().getDrawable(
						R.drawable.black1p25));
				holder.addView(a25);
				a25.setOnClickListener(this);
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

		holder.removeAllViews();

		String value = s.toString();
		if (value.compareTo("") != 0) {
			Double d = Double.valueOf(value);

			ArrayList<Double> aL = calculateWeights(d, 0);

			createViews(aL);

			aL.clear();

		}

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
		Log.i("Weight", v.getId() + "");
	}

}