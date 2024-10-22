package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Engagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engagement);

        ImageButton back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity2.this, home.class);
            finish();
        });

        ImageButton homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Engagement.this, home.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });

        ImageButton button_7=findViewById(R.id.btn_1);

        button_7.setOnClickListener(view -> {
            Intent i=new Intent(Engagement.this,Gallery.class);
            startActivity(i);
        });

    }
}