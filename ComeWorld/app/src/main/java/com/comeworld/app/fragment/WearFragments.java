package com.comeworld.app.fragment;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.comeworld.app.MainActivity;
import com.comeworld.app.R;


/**
 * Created by come on 24/06/14.
 */
public class WearFragments extends Fragment implements View.OnClickListener {

	private static final String EXTRA_EVENT_ID = "extra";

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
		return inflater.inflate(R.layout.frg_wear, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		Button button = (Button) view.findViewById(R.id.button);
		button.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.button:
				int notificationId = 001;
				// Build intent for notification content
				Intent viewIntent = new Intent(getActivity(), MainActivity.class);
				int eventId = 0;
				viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
				PendingIntent viewPendingIntent =
						PendingIntent.getActivity(getActivity(), 0, viewIntent, 0);

				// Build an intent for an action to view a map
				Intent mapIntent = new Intent(Intent.ACTION_VIEW);
				PendingIntent mapPendingIntent =
						PendingIntent.getActivity(getActivity(), 0, mapIntent, 0);


				NotificationCompat.Builder notificationBuilder =
						new NotificationCompat.Builder(getActivity())
								.setSmallIcon(R.drawable.ic_launcher)
								.setContentTitle("My title")
								.setContentText("test for do a fck notification !!!")
								.setContentIntent(viewPendingIntent)
								.addAction(R.drawable.abc_ic_clear_disabled,
										getString(R.string.abc_action_mode_done), mapPendingIntent);

// Get an instance of the NotificationManager service
//				NotificationManagerCompat notificationManager =
//						NotificationManagerCompat.from(getActivity());
//
//Build the notification and issues it with notification manager.
//				notificationManager.notify(notificationId, notificationBuilder.build());
				break;
			default:
				break;
		}
	}
}
