package com.bqdropbook.ui.activities;

import java.util.List;

import com.bqdropbook.BQDropbook;
import com.bqdropbook.async.GetFilesTask;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LibraryActivity extends Activity {

	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.library_layout);
		BQDropbook bqdropbook = ((BQDropbook)getApplicationContext());
		mDBApi = bqdropbook.getSession();
		
		new GetFilesTask().execute(mDBApi);
		
	}
	
	
}
