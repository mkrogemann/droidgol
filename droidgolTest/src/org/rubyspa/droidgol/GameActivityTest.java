package org.rubyspa.droidgol;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class org.rubyspa.droidgol.GameActivityTest \
 * org.rubyspa.droidgol.tests/android.test.InstrumentationTestRunner
 */
public class GameActivityTest extends ActivityInstrumentationTestCase2<GameActivity> {

    public GameActivityTest() {
        super("org.rubyspa.droidgol", GameActivity.class);
    }

}
