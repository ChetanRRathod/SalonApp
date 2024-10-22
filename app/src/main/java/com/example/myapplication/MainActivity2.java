package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity2.this, home.class);
            finish();
        });

        ImageButton homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, home.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });


        ImageButton button_1 = findViewById(R.id.btn_1);

        button_1.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this, Bridal_Makeup.class);
            startActivity(i);
        });

        ImageButton button_2 = findViewById(R.id.btn_2);

        button_2.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this, Engagement.class);
            startActivity(i);
        });


        ImageButton button_3 = findViewById(R.id.btn_3);

        button_3.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this, Mehandi_and_Haldi.class);
            startActivity(i);
        });


        ImageButton button_4 = findViewById(R.id.btn_4);

        button_4.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity2.this, Simple_Makeup.class);
            startActivity(i);
        });


    }
}