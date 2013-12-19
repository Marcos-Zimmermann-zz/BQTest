package com.bqdropbook.ui.activities;

import com.bqdropbox.dropbox.Dropbox;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class LoginActivity extends Activity {
	
	private DropboxAPI<AndroidAuthSession> mDBApi;
	private boolean logged = false;
	public final static String TOKEN = "com.bqdropbook.ui.activities.TOKEN";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		mDBApi = null;
	}
	
	@Override
	protected void onResume() {
	    super.onResume();

	    if (logged && mDBApi.getSession().authenticationSuccessful()) {
	        try {
	            // Required to complete auth, sets the access token on the session
	            mDBApi.getSession().finishAuthentication();

	            AccessTokenPair token = mDBApi.getSession().getAccessTokenPair();
	            Intent intent = new Intent(getApplicationContext(), LibraryActivity.class);
	            //intent.setClassName("com.bqdropbook.ui.activities", "com.bqdropbook.ui.activities.LibraryActivity.class");
	            
	            intent.putExtra(TOKEN,token);	            
	            startActivity(intent);
	        } catch (IllegalStateException e) {
	        	logged = false;
	            Log.i("DbAuthLog", "Error authenticating", e);
	        }
	    }
	}
	
	public void onClick(View v) {
		final int id = v.getId();
		if(R.id.button1 == id) {
			mDBApi = new Dropbox().getMDBApi();
			logged = true;
			mDBApi.getSession().startAuthentication(LoginActivity.this);
		}
	}
}
