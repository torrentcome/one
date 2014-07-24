package com.comeworld.app.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.comeworld.app.R;

import java.util.ArrayList;
import java.util.List;


public class CalculFragments extends Fragment {

	private int[] tab = {1, 2, 3, 4, 5, 6, 7, 8};
	private Button button;
	private LinearLayout layout;
	private LinearLayout container;
	private List<int[]> listofRes;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement SelectInTab");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frg_calcul, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		container = (LinearLayout) view.findViewById(R.id.container);
		button = (Button) view.findViewById(R.id.button);
		layout = (LinearLayout) view.findViewById(R.id.layout);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				listofRes = new ArrayList<int[]>();
				container.removeAllViews();
				new DownloadFilesTask().execute();
			}
		});

		TextView e = new TextView(getActivity());
		e.setPadding(4, 4, 4, 4);
		e.setTextColor(Color.WHITE);
		e.setText("Tableau de depart : " + tab[0] + ";" + tab[1] + ";" + tab[2] + ";" + tab[3] + ";" + tab[4] + ";" + tab[5] + ";" + tab[6] + ";" + tab[7]);
		layout.addView(e);

	}

	public void permute(int[] input2, int startindex) {
		if (input2.length == startindex) {
			if (input2[0] + input2[1] + input2[2] + input2[3] == 20)
				if (input2[4] + input2[5] + input2[6] + input2[7] == 16)
					displayArray(input2);
		} else {
			for (int i = startindex; i < input2.length; i++) {
				int[] input = input2.clone();
				int temp = input[i];
				input[i] = input[startindex];
				input[startindex] = temp;
				permute(input, startindex + 1);
			}
		}
	}

	private void displayArray(int[] input) {
		listofRes.add(input);
		Log.i("ok", "********************************************************");
		Log.i("ok", input[0] + ";" + input[1] + ";" + input[2] + ";" + input[3]);
		Log.i("ok", input[4] + ";" + input[5] + ";" + input[6] + ";" + input[7]);
	}

	private class DownloadFilesTask extends AsyncTask<Integer, Integer, Integer> {
		protected Integer doInBackground(Integer... urls) {
			permute(tab, 0);
			return 0;
		}

		protected void onProgressUpdate(Integer... progress) {
		}

		protected void onPostExecute(Integer result) {
			for (int i = 0; i < listofRes.size(); i++) {
				TextView e = new TextView(getActivity());
				e.setPadding(4, 4, 4, 4);
				e.setTextColor(Color.WHITE);
				e.setText(listofRes.get(i)[0] + ";" + listofRes.get(i)[1] + ";" + listofRes.get(i)[2] + ";" + listofRes.get(i)[3] + ";" + listofRes.get(i)[4] + ";" + listofRes.get(i)[5] + ";" + listofRes.get(i)[6] + ";" + listofRes.get(i)[7]);
				container.addView(e);
			}
		}
	}
}
