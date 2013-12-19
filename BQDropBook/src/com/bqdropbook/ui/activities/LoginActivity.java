package com.bqdropbook.ui.activities;

import com.bqdropbook.R;
import com.bqdropbox.dropbox.Dropbox;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.Session.AccessType;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class LoginActivity extends Activity {
	
	private DropboxAPI<AndroidAuthSession> mDBApi;
	
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
	
	/*@Override
	protected void onResume() {
	    super.onResume();

	    if (mDBApi.getSession().authenticationSuccessful()) {
	        try {
	            // Required to complete auth, sets the access token on the session
	            mDBApi.getSession().finishAuthentication();

	            AccessTokenPair tokens = mDBApi.getSession().getAccessTokenPair();
	        } catch (IllegalStateException e) {
	            Log.i("DbAuthLog", "Error authenticating", e);
	        }
	    }
	}*/
	
	public void onClick(View v) {
		final int id = v.getId();
		if(R.id.button1 == id) {
			mDBApi = new Dropbox().getMDBApi();
			Log.i("debug", "YOLO");
			mDBApi.getSession().startAuthentication(LoginActivity.this);
		}
	}
}
