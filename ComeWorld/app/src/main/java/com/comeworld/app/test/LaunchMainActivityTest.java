package com.comeworld.app.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.FrameLayout;

import com.comeworld.app.MainActivity;
import com.comeworld.app.SimpleActivity;

/**
 * Created by come on 21/07/14.
 */
public class LaunchMainActivityTest extends ActivityUnitTestCase<SimpleActivity> {

	private SimpleActivity mFirstActivity;
	private FrameLayout mFirstLayout;
	private Intent mLaunchIntent;

	public LaunchMainActivityTest() {
		super(SimpleActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mLaunchIntent = new Intent(getInstrumentation()
				.getTargetContext(), MainActivity.class);
		mFirstActivity = startActivity(mLaunchIntent, null, null);

//		mFirstActivity = getActivity();
//		mFirstLayout = (FrameLayout) mFirstActivity.findViewById(R.id.container);
	}

	public void testPreconditions() {
		assertNotNull("mFirstActivity is null", mFirstActivity);
//		assertNotNull("mFirstLayout is null", mFirstLayout);
	}

//	public void testMyFirstTestTextView_labelText() {
//		final int actual = mFirstLayout.getId();
//		assertEquals("mFirstTestText contains wrong text", 2, actual);
//	}

}
