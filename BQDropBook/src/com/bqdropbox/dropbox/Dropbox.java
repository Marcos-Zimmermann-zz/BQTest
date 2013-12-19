package com.bqdropbox.dropbox;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;

public class Dropbox {
	
	final static private String APP_KEY = "bx7bulmkfytdumf";
	final static private String APP_SECRET = "isvq7nesyfkbyq3";
	final static private AccessType ACCESS_TYPE = AccessType.DROPBOX;
	
	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	public Dropbox() {
		AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
		AndroidAuthSession session = new AndroidAuthSession(appKeys, ACCESS_TYPE);
		mDBApi = new DropboxAPI<AndroidAuthSession>(session);
	}
	
	public DropboxAPI<AndroidAuthSession> getMDBApi() {
		return mDBApi;
	}
	
}
