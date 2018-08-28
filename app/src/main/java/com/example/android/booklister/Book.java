package com.example.android.booklister;


public class Book {

    String mThumbnailUrl;
    String mTitle;
    String mPublisher;
    String mPublishedDate;
    int mRating;
    String mInfoUrl;

    public Book(String thumbnailUrl, String title, String publisher, String publishedDate, int rating, String infoUrl){
        mThumbnailUrl = thumbnailUrl;
        mTitle = title;
        mPublisher = publisher;
        mPublishedDate = publishedDate;
        mRating = rating;
        mInfoUrl = infoUrl;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPublisher(){
        return  mPublisher;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public int getRating() {
        return mRating;
    }

    public String getInfoUrl() {
        return mInfoUrl;
    }
}
