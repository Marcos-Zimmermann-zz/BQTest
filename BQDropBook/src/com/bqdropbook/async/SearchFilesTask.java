package com.bqdropbook.async;

import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;

import android.os.AsyncTask;

public class SearchFilesTask extends AsyncTask<DropboxAPI<AndroidAuthSession>, Void, List<Entry>>{
	
	@Override
	protected List<Entry> doInBackground(DropboxAPI<AndroidAuthSession>... mDBApi) {
		
		List<Entry> CFolder = null;
		
		try {
			CFolder = mDBApi[0].search("/", ".epub", 0, false);
		} catch (DropboxException e) {
			e.printStackTrace();
		}
		
		return CFolder;
	}

}