package com.thomaz.ambiduos;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.test.mock.MockContext;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AmbiduosApplicationUnitTest extends InstrumentationTestCase {

    Context context;

    public void setUp() throws Exception {
        super.setUp();

        context = new MockContext();

        assertNotNull(context);
    }

    public void testBuscar() {

    }

}