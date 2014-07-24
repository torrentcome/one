package com.comeworld.app.test;

import android.test.InstrumentationTestCase;

/**
 * Created by come on 21/07/14.
 */
public class ExampleTest extends InstrumentationTestCase {
	public void test() throws Exception {
		final int expected = 1;
		final int reality = 1;
		assertEquals(expected, reality);
	}
}