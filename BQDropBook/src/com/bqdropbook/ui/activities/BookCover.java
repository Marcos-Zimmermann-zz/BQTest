package com.bqdropbook.ui.activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;

import com.bqdropbook.async.GetFilesTask;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class BookCover extends Activity{
	
	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_cover_layout);
		
		Intent intent = getIntent();
		
		int resource = intent.getExtras().getInt("resource");
				
		ImageView imgView = (ImageView) findViewById(R.id.imageView1);
		Drawable res = getResources().getDrawable(resource);
		imgView.setImageDrawable(res);
		
		//BQDropbook bqdropbook = ((BQDropbook)getApplicationContext());
		//mDBApi = bqdropbook.getSession();
		
	}
	
	private String getEpubTitle(){
		
		EpubReader epubReader = new EpubReader();
		Book book = null;
		try {
		File epubBook = new GetFilesTask().execute(mDBApi).get();
			book = epubReader.readEpub(new FileInputStream(epubBook));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	
		// print the first title
		String title = book.getMetadata().getTitles().get(0);
		
		return title;
	}
}
