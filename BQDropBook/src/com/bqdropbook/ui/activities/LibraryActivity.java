package com.bqdropbook.ui.activities;

import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LibraryActivity extends Activity {

	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.library_layout);
		
		Intent intent = getIntent();
		AccessTokenPair token = (AccessTokenPair) intent.getSerializableExtra(LoginActivity.TOKEN);
		
		/*
		Entry contact = null;
		try {
			contact = mDBApi.metadata("/", 0, null, true, null);
			List<Entry> CFolder = contact.contents;
		    for (Entry entry : CFolder) {
		    Log.i("DbExampleLog", "Filename: " + entry.fileName());}
		} catch (DropboxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	    
	}
	
	
}
