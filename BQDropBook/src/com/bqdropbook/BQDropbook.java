package com.bqdropbook;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;

import android.app.Application;

public class BQDropbook extends Application {
	
	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	public DropboxAPI<AndroidAuthSession> getSession(){
		return mDBApi;
	}
	public void setSession(DropboxAPI<AndroidAuthSession> mDBApi){
		this.mDBApi = mDBApi;
	}
}
