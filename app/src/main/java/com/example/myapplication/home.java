package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        ImageButton button_1=findViewById(R.id.button_1);

        button_1.setOnClickListener(view -> {
            Intent i=new Intent(home.this,MainActivity2.class);
            startActivity(i);
        });

        ImageButton button_2=findViewById(R.id.button_2);

        button_2.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Pre_Bride.class);
            startActivity(i);
        });

        ImageButton button_3=findViewById(R.id.button_3);

        button_3.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Facials_and_Skin.class);
            startActivity(i);
        });

        ImageButton button_4=findViewById(R.id.button_4);

        button_4.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Body_spa_and_Dtan.class);
            startActivity(i);
        });

        ImageButton button_5=findViewById(R.id.button_5);

        button_5.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Hare_care.class);
            startActivity(i);
        });

        ImageButton button_6=findViewById(R.id.button_6);

        button_6.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Manicure_Pedicure.class);
            startActivity(i);
        });

        ImageButton button_7=findViewById(R.id.button_7);

        button_7.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Gallery.class);
            startActivity(i);
        });

        ImageButton button_8=findViewById(R.id.button_8);

        button_8.setOnClickListener(view -> {
            Intent i=new Intent(home.this,About_us.class);
            startActivity(i);
        });

        ImageButton button_9=findViewById(R.id.button_9);

        button_9.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Appointment.class);
            startActivity(i);
        });

        ImageButton button_10=findViewById(R.id.button_10);

        button_10.setOnClickListener(view -> {
            Intent i=new Intent(home.this,Contact_Us.class);
            startActivity(i);
        });

    }

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            //super.onBackPressed();
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }
}