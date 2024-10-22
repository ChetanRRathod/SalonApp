package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Contact_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);



        Button phoneButton = findViewById(R.id.phoneButton);
        Button whatsappButton = findViewById(R.id.whatsappButton);
        Button emailButton = findViewById(R.id.emailButton);
        Button instagramButton = findViewById(R.id.instagramButton);
        Button facebookButton = findViewById(R.id.facebookButton);

        ImageButton back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity2.this, home.class);
            finish();
        });

        ImageButton homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Contact_Us.this, home.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });


        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the phone dialer with the specified phone number
                String phoneNumber = "+9322037721";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        whatsappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open WhatsApp chat with the specified phone number
                String phoneNumber = "+9322037721";
                Uri uri = Uri.parse("https://wa.me/" + phoneNumber);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an email intent
                String email = "chetanrathod1110@gmail.com";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + email));

                // You can also specify a subject and body for the email
                // emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                // emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");

                // Start the email client
                startActivity(emailIntent);
            }
        });



        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Instagram profile
                String instagramProfile = "https://www.instagram.com/hariom_ingle_/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfile));
                startActivity(intent);
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Facebook page
                String facebookPage ="fb://profile/100040897604371";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPage));
                startActivity(intent);
            }
        });



    }
}