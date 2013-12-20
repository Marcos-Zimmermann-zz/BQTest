package com.bqdropbook.ui.activities;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.bqdropbook.BQDropbook;
import com.bqdropbook.async.SearchFilesTask;
import com.bqdropbook.data.Book;
import com.bqdropbook.ui.adapter.BookAdapter;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

public class LibraryActivity extends ListActivity {

	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.library_layout);
		BQDropbook bqdropbook = ((BQDropbook)getApplicationContext());
		mDBApi = bqdropbook.getSession();
		
		Book[] books = getBooks();
		
		BookAdapter bookadapter = new BookAdapter(this, books);
		setListAdapter(bookadapter);
		
	}
	
	@Override
	public void onBackPressed() {
		   Intent intent = new Intent(Intent.ACTION_MAIN);
		   intent.addCategory(Intent.CATEGORY_HOME);
		   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   startActivity(intent);
	}
	
	private Book[] getBooks(){
		
		Book[] books = null;
		
		try {
			List<Entry> BFolder = new SearchFilesTask().execute(mDBApi).get();
			
			books = new Book[BFolder.size()];
			Entry entry;
			
			for(int i = 0; i < books.length; i++){
				entry = BFolder.get(i);
				books[i] = new Book(entry.fileName());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
}
