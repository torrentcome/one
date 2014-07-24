package com.comeworld;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.comeworld.app.MainActivity;

/**
 * Created by come on 21/07/14.
 */
@LargeTest
public class ActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	@SuppressWarnings("deprecation")
	public ActivityTest() {
		// This constructor was deprecated - but we want to support lower API levels.
		super("com.comeworld.app.MainActivity", MainActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		// Espresso will not launch our activity for us, we must launch it via getActivity().
		getActivity();
	}

	public void testCheckText() {
//		onView(withId(R.id.text))
//				.check(matches(withText("Hello Espresso!")));
	}
}