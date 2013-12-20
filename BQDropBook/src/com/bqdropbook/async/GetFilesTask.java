package com.bqdropbook.async;

import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;

import android.os.AsyncTask;
import android.util.Log;

public class GetFilesTask extends AsyncTask<DropboxAPI<AndroidAuthSession>, Integer, List<Entry>>{
	
	@Override
	protected List<Entry> doInBackground(DropboxAPI<AndroidAuthSession>... mDBApi) {
		
		List<Entry> CFolder = null;
		
		try {
			Entry contact = mDBApi[0].metadata("", 0, null, true, null);
		    CFolder = contact.contents;
		    for (Entry entry : CFolder) {
		    Log.i("DbExampleLog", "Filename: " + entry.fileName());}
		} catch (DropboxException e) {
			e.printStackTrace();
		}
		
		return CFolder;
	}
	
	/*
	@Override
    protected void onProgressUpdate(Integer... progress) {
        setProgressPercent(progress[0]);
    }

	@Override
    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }
	*/
}
