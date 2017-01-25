package com.sss8000.beaconNActivities;

import com.sss8000.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);

		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1500);
				} catch (Throwable ex) {
					ex.printStackTrace();
				}
				Intent i = new Intent(IntroActivity.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}).start();
	}
}
