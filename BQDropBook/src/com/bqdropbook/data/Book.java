package com.bqdropbook.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String isbn;

    private double avgRate;
    private String title;
    private String summary;
    private double price;
    private String author;
    private String image;
    private String[] topics;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(final double avgRate) {
        this.avgRate = avgRate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double d) {
        this.price = d;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(final String[] topics) {
        this.topics = topics;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(isbn);
        dest.writeDouble(avgRate);
        dest.writeString(title);
        dest.writeString(summary);
        dest.writeDouble(price);
        dest.writeString(author);
        dest.writeString(image);
        dest.writeStringArray(topics);
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(final Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(final int size) {
            return new Book[size];
        }
    };

    private Book(final Parcel in) {
        isbn = in.readString();
        avgRate = in.readDouble();
        title = in.readString();
        summary = in.readString();
        price = in.readDouble();
        author = in.readString();
        image = in.readString();
        topics = in.createStringArray();
    }

    /**
     * Constructor without parameters.
     */
    public Book() {
        super();
    }

}
