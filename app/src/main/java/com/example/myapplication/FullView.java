package com.example.myapplication;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.media.ImageWriter;
//import android.os.Bundle;
//import android.widget.ImageView;
//
//public class FullView extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_full_view);
//
//        ImageView imageView= findViewById(R.id.img_full);
//        int img_id =getIntent().getExtras().getInt("img_id");
//        imageView.setImageResource(img_id);
//    }
//}


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;

public class FullView extends AppCompatActivity {

    ArrayList<Integer> mImageIds = new ArrayList<>(Arrays.asList(
            R.drawable.photo1,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,R.drawable.photo7, R.drawable.photo8
            ,R.drawable.photo10,R.drawable.photo11,R.drawable.photo12,R.drawable.photo13,R.drawable.photo14, R.drawable.photo2
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        int initialImageResource = getIntent().getIntExtra("img_id", -1);
        if (initialImageResource != -1) {
            int initialImageIndex = mImageIds.indexOf(initialImageResource);
            if (initialImageIndex >= 0) {
                viewPager.setCurrentItem(initialImageIndex);
            }
        }
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int imageResource = mImageIds.get(position);
            return new ImageFragment(imageResource);
        }

        @Override
        public int getCount() {
            return mImageIds.size();
        }
    }
}