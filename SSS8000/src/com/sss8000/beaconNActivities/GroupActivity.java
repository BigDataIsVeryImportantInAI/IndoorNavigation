package com.sss8000.beaconNActivities;

import com.sss8000.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GroupActivity extends Activity {
	private static final int GROUP_POS_EXIT = 2;
	/** Called when the activity is first created. */
	private Button exitBtn;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_group);
	    exitBtn = (Button) findViewById(R.id.exitBtn);
	    exitBtn.setOnClickListener(mClickListener);
	    // TODO Auto-generated method stub
	    
	}

	OnClickListener mClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.exitBtn:
				Intent intent = new Intent();
				setResult(GROUP_POS_EXIT, intent);
				finish();
				break;
			}
		}
	};
}
