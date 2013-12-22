package com.bqdropbook.async;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;

import android.os.AsyncTask;
import android.util.Log;

public class GetFilesTask extends AsyncTask<DropboxAPI<AndroidAuthSession>, Void, File>{

	@Override
	protected File doInBackground(DropboxAPI<AndroidAuthSession>... mDBApi) {

		DropboxFileInfo info = null;
		
		File file = new File("/a.epub");
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(file);
			info = mDBApi[0].getFile("/a.epub", null, outputStream, null);
			Log.i("DbExampleLog", "The file's rev is: " + info.getMetadata().rev);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DropboxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}
	
}
