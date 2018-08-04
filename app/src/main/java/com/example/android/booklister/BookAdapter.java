package com.example.android.booklister;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books){
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list, parent, false);
        }

        Book currentBook = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentBook != null) {
            Glide.with(imageView.getContext())
                    .load(currentBook.getThumbnailUrl())
                    .into(imageView);
        }

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentBook.getTitle());

        TextView publishTextView = (TextView) listItemView.findViewById(R.id.published_text_view);
        publishTextView.setText(currentBook.getPublisher() + ", " + currentBook.getPublishedDate());

        TextView ratingTextView = (TextView) listItemView.findViewById(R.id.rating);
        ratingTextView.setText("" + currentBook.getRating());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

//    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
//        ImageView bmImage;
//        public DownloadImageTask(ImageView bmImage) {
//            this.bmImage = bmImage;
//        }
//
//        protected Bitmap doInBackground(String... urls) {
//            String urldisplay = urls[0];
//            Bitmap bmp = null;
//            try {
//                InputStream in = new java.net.URL(urldisplay).openStream();
//                bmp = BitmapFactory.decodeStream(in);
//            } catch (Exception e) {
//                Log.e("Error", e.getMessage());
//                e.printStackTrace();
//            }
//            return bmp;
//        }
//
//        protected void onPostExecute(Bitmap result) {
//            bmImage.setImageBitmap(result);
//        }
//    }
}
