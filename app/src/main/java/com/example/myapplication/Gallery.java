package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Gallery extends AppCompatActivity {



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gallery);
//    }


    ArrayList<Integer> mImageIds = new ArrayList<>(Arrays.asList(
            R.drawable.photo1,R.drawable.photo10,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,R.drawable.photo7, R.drawable.photo8,R.drawable.photo11,R.drawable.photo12,R.drawable.photo13,R.drawable.photo14,R.drawable.photo2

    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        GridView gridView = findViewById(R.id.myGrid);
        gridView.setAdapter( new ImageAdaptor(mImageIds,this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                int item_pos = mImageIds.get(i);
                openFullScreenImage(item_pos);
            }
        });

        ImageButton back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity2.this, home.class);
            finish();
        });

        ImageButton homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, home.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });
    }
    public void openFullScreenImage(int item_pos) {
        Intent intent = new Intent(Gallery.this, FullView.class);
        intent.putExtra("img_id", item_pos);
        startActivity(intent);
    }
}

