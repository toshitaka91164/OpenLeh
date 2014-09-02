package com.example.openleh;

import java.util.Timer;
import java.util.TimerTask;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	private long splashDelay = 5000; //5 seconds
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        TimerTask task = new TimerTask()
        {

			@Override
			public void run() {
				finish();
				Intent mainIntent = new Intent().setClass(Splash.this, MainActivity.class);
				startActivity(mainIntent);
			}
        	
        };
        
        Timer timer = new Timer();
        timer.schedule(task, splashDelay);
    }
}
