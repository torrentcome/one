package com.comeworld;

import android.app.Activity;

import com.comeworld.app.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by come on 21/07/14.
 */
@Config(manifest = "./src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class MainActivityRobolectricTest {
	@Test
	public void testSomething() throws Exception {
		Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
		assertTrue(activity != null);
	}
}