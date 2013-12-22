package com.bqdropbook.ui.adapter;

import com.bqdropbook.data.Book;
import com.bqdropbook.ui.activities.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<Book> {

    private final Context context;
    private Book[] books = null;

    /**
     * Constructor with parameters.
     * 
     * @param context activity context
     * @param layoutResourceId resource identifier
     * @param books array of books info to show
     */
    public BookAdapter(final Context context, final Book[] books) {

        super(context, R.layout.library_row_layout, books);
        this.context = context;
        this.books = books;

    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View row = convertView;

        if (row == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.library_row_layout, parent, false);
            
            //ImageView imageView = (ImageView) row.findViewById(R.id.icon);
            TextView nameView = (TextView) row.findViewById(R.id.name);
            TextView dateView = (TextView) row.findViewById(R.id.date);
                        
            nameView.setText(books[position].getName());
            dateView.setText(books[position].getModificationDate());
        }

        return row;

    }
    
}
