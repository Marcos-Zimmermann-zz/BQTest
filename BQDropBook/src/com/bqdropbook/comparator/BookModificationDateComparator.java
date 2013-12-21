package com.bqdropbook.comparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;



import java.util.Locale;

import com.bqdropbook.data.Book;

public class BookModificationDateComparator implements Comparator<Book>{

	@Override
	public int compare(Book lhs, Book rhs) {
		if (lhs.getModificationDate() == null || rhs.getModificationDate() == null)
	        return 0;
		
		 try {
	         SimpleDateFormat dateFormatlhs = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
	         Date convertedDatelhs = dateFormatlhs.parse(lhs.getModificationDate());
	         Calendar calendarlhs = Calendar.getInstance();
	         calendarlhs.setTime(convertedDatelhs);
	
	         SimpleDateFormat dateFormatrhs = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
	         Date convertedDaterhs = dateFormatrhs.parse(rhs.getModificationDate());
	         Calendar calendarrhs = Calendar.getInstance();
	         calendarrhs.setTime(convertedDaterhs);
	
	         if(calendarlhs.getTimeInMillis() > calendarrhs.getTimeInMillis())
	         {   
	             return -1;
	         }
	         else
	         {
	             return 1;
	         }
		 } catch (ParseException e) {

             e.printStackTrace();
         }
		return 0;
	}

}
