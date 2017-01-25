package com.sss8000.beaconNActivities;

import java.util.ArrayList;

import com.sss8000.R;
import com.sss8000.databases.PoisDbOpenHelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class GroupMenuActivity extends Activity {
	
	private Button enterBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_menu);
		enterBtn = (Button) findViewById(R.id.enterBtn);
		enterBtn.setOnClickListener(mClickListener);
	}
	
	OnClickListener mClickListener = new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.enterBtn:
			startActivity(new Intent(getApplicationContext(), GroupActivity.class));
			finish();
			break;
		}
	}
};

}
