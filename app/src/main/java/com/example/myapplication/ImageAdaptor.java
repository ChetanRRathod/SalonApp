package com.example.myapplication;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdaptor extends BaseAdapter {
    private final List<Integer> mThumbIds;
    private final Context mContext;

    public ImageAdaptor(List<Integer> mThumbIds, Context mContext) {
        this.mThumbIds = mThumbIds;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return mThumbIds.get(i);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView) convertView;

        if (imageView == null) {
            imageView = new ImageView(mContext);
            int imageSize = getImageSize();
            GridView.LayoutParams params = new GridView.LayoutParams(imageSize, imageSize);
            imageView.setPadding(8, 8, 8, 8); // Add margins to avoid sticking
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        imageView.setImageResource(mThumbIds.get(i));
        return imageView;
    }

    // Calculate image size based on screen width
    private int getImageSize() {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int screenWidth = displayMetrics.widthPixels;
        // You can adjust this factor based on your design
        return screenWidth / 2; // Set to half of the screen width for two columns
    }
}
