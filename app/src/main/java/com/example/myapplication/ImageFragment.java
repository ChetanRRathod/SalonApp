package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class ImageFragment extends Fragment {
    private int imageResource;

    public ImageFragment(int imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_image_fragment, container, false);
        ImageView imageView = rootView.findViewById(R.id.imageView);
        imageView.setImageResource(imageResource);
        return rootView;
    }
}