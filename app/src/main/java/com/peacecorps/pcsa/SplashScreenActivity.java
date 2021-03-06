package com.peacecorps.pcsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

/**
 * This class handles showing splash screen for 2500 ms when the application is launched
 * @author rohan
 * @since 2016-06-10.
 */
public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT = 2500;
    private ProgressBar progressBar;
    private Handler handler;
    private Runnable runnable;

    /**
     * Instance of Handler class is used to load the main screen after 2500 ms
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        progressBar = (ProgressBar)findViewById(R.id.splash_screen_progress);
        progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.background_textview),android.graphics.PorterDuff.Mode.MULTIPLY);
        progressBar.setVisibility(View.VISIBLE);
        runnable = new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                Intent i = new Intent(SplashScreenActivity.this, SignupActivity.class);
                startActivity(i);
                finish();
            }
        };
        handler = new Handler();
        handler.postDelayed(runnable, SPLASH_TIME_OUT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
