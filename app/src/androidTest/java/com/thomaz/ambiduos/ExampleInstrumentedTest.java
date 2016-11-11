package com.thomaz.ambiduos;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.thomaz.ambiduos.fragment.Locador.ConsultarLocacoesFragment;
import com.thomaz.ambiduos.to.Cacamba;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.thomaz.ambiduos", appContext.getPackageName());
    }

    @Test
    public void buscarCacamba() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        Cacamba encontrada = ConsultarLocacoesFragment.buscarCacamba(6, appContext);

        assertEquals(5, encontrada.getId());
    }
}
