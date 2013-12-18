package com.bqdropbook.ui.activities;

import com.bqdropbook.R;
import com.dropbox.client2.session.Session.AccessType;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LoginActivity extends Activity {

	final static private String APP_KEY = "o7s0zr9scqz8k9p";
	final static private String APP_SECRET = "0fjx78v2hbrbh6n";
	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
