package com.thomaz.ambiduos;

import android.app.Activity;
import android.os.Handler;

import org.androidannotations.annotations.EActivity;

/**
 * Created by thomaz on 03/10/16.
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();

        /* Duration of wait */
        final int SPLASH_DISPLAY_LENGTH = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity_.intent(SplashActivity.this).start();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
