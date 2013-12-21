package com.bqdropbook.comparator;

import java.util.Comparator;

import com.bqdropbook.data.Book;

public class BookNameComparator implements Comparator<Book> {

	@Override
	public int compare(Book lhs, Book rhs) {
		return lhs.getName().compareTo(rhs.getName());
	}

}