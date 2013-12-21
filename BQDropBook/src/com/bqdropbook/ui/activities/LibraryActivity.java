package com.bqdropbook.ui.activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.bqdropbook.BQDropbook;
import com.bqdropbook.async.SearchFilesTask;
import com.bqdropbook.comparator.BookModificationDateComparator;
import com.bqdropbook.comparator.BookNameComparator;
import com.bqdropbook.data.Book;
import com.bqdropbook.ui.adapter.BookAdapter;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.android.AndroidAuthSession;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class LibraryActivity extends ListActivity {

	private DropboxAPI<AndroidAuthSession> mDBApi;
	
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//ActionBar actionBar = setActionBar();
		
		super.onCreate(savedInstanceState);
	    //setContentView(R.layout.activity_main);

	    // Set up the action bar to show a dropdown list.
	    final ActionBar actionBar = getActionBar();
	    actionBar.setDisplayShowTitleEnabled(false);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

	    final String[] dropdownValues = getResources().getStringArray(R.array.library_spinner);

	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(actionBar.getThemedContext(),
	        android.R.layout.simple_spinner_item, android.R.id.text1,
	        dropdownValues);

	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    
	    BQDropbook bqdropbook = ((BQDropbook)getApplicationContext());
		mDBApi = bqdropbook.getSession();
		final Book[] books = getBooks();
	    
	    actionBar.setListNavigationCallbacks(adapter, new OnNavigationListener() {
	
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		
				switch (itemPosition) {
				case 0:
					Toast.makeText(getApplicationContext(), "Unsorted items", Toast.LENGTH_LONG).show();
					DisplayBooks(books);
					break;
				case 1:
					Toast.makeText(getApplicationContext(), "Sorting alphabetically", Toast.LENGTH_LONG).show();
					DisplayBooks(sortAlphabetically(books));
					break;
				case 2:
					Toast.makeText(getApplicationContext(), "Sorting by date of creation", Toast.LENGTH_LONG).show();
					DisplayBooks(sortByModificationDate(books));
					break;
				default:
				 break;
			}

		 return true;
		 }
		 });

		DisplayBooks(books);
		
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
				books[i] = new Book(entry.fileName(), entry.modified);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return books;
	}
	
	private void DisplayBooks(Book[] books){
		
		BookAdapter bookadapter = new BookAdapter(this, books);
		setListAdapter(bookadapter);
	}
	
	private Book[] sortAlphabetically(Book[] books){
		
		ArrayList<Book> unsortedBooks = new ArrayList<Book>();
		
		for(int i = 0; i < books.length; i++){
			unsortedBooks.add(books[i]);
		}
		
		BookNameComparator comparator = new BookNameComparator();
		Collections.sort(unsortedBooks, comparator);
		
		return unsortedBooks.toArray(new Book[books.length]);
	}
	
	private Book[] sortByModificationDate(Book[] books){
		
		ArrayList<Book> unsortedBooks = new ArrayList<Book>();
		
		for(int i = 0; i < books.length; i++){
			unsortedBooks.add(books[i]);
		}
		
		BookModificationDateComparator comparator = new BookModificationDateComparator();
		Collections.sort(unsortedBooks, comparator);
		
		return unsortedBooks.toArray(new Book[books.length]);
	}
}
