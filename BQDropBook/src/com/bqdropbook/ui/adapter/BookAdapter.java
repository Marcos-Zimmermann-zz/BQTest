package com.bqdropbook.ui.adapter;

import java.text.DecimalFormat;

import com.bqdropbook.data.Book;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookAdapter extends ArrayAdapter<Book> {

    private final Context context;
    private final int layoutResourceId;
    private Book[] books = null;

    /**
     * Constructor with parameters.
     * 
     * @param context activity context
     * @param layoutResourceId resource identifier
     * @param books array of books info to show
     */
    public BookAdapter(final Context context, final int layoutResourceId, final Book[] books) {

        super(context, layoutResourceId, books);

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.books = books;

    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View row = convertView;
        BookHolder holder = null;

        if (row == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            /*
            holder = new BookHolder();
            holder.image = (ImageView) row.findViewById(R.id.image);
            holder.title = (TextView) row.findViewById(R.id.title);
            holder.author = (TextView) row.findViewById(R.id.author);
            holder.price = (TextView) row.findViewById(R.id.price);
			*/
            row.setTag(holder);
        } else {
            holder = (BookHolder) row.getTag();
        }

        Book book = books[position];
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.price.setText(formatPrice(book.getPrice()));

        // Load image on asynctask (not ui-thread)
        //ImageLoader.getInstance().displayImage(book.getImage(), holder.image);

        return row;

    }

    private String formatPrice(final double price) {

        DecimalFormat df = new DecimalFormat("##0.00");
        return df.format(price) + " €";

    }

    /**
     * Holder of Book object that defines it.
     */
    static class BookHolder {

        private ImageView image;
        private TextView title;
        private TextView author;
        private TextView price;
    }
 
}
