package com.bqdropbook.ui.activities;

import com.bqdropbook.BQDropbook;
import com.bqdropbox.dropbox.Dropbox;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class LoginActivity extends Activity {
	
	private DropboxAPI<AndroidAuthSession> mDBApi;
	private boolean logged = false;
	private BQDropbook bqdropbook;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bqdropbook = ((BQDropbook)getApplicationContext());
		setContentView(R.layout.login_layout);

		//Dropbox connection
		mDBApi = new Dropbox().getMDBApi();
		logged = true;
		mDBApi.getSession().startAuthentication(LoginActivity.this);
	}
	
	@Override
	protected void onResume() {
	    super.onResume();

	    if (logged && mDBApi.getSession().authenticationSuccessful()) {
	        try {
	            // Required to complete auth, sets the access token on the session
	            mDBApi.getSession().finishAuthentication();

	            Intent intent = new Intent(getApplicationContext(), LibraryActivity.class);
	            bqdropbook.setSession(mDBApi);
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
