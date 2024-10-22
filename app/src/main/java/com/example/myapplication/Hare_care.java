package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Hare_care extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hare_care);

        ImageButton back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity2.this, home.class);
            finish();
        });

        ImageButton homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hare_care.this, home.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });

//        TableLayout tableLayout = findViewById(R.id.table2); // Replace with your actual TableLayout ID
//
//// Example data
//        String[] rowData = {"", "Data2", "Data3", "Data4"};
//
//        for (int i = 0; i < rowData.length; i++) {
//            // Create a new TableRow
//
//            TableRow tableRow = new TableRow(this);
//
//            tableRow.setPadding(5,5,5,5);
//
//            // Create a new TextView
//            TextView textView = new TextView(this);
//            textView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
//            textView.setGravity(Gravity.LEFT);
////            textView.setPadding(5, 5, 5, 5);
//            textView.setTextColor(ContextCompat.getColor(this, R.color.white)); // Replace with your color resource
//
//            // Set the text for the TextView from the data array
//            textView.setText(rowData[i]);
//
//            // Add the TextView to the TableRow
//            tableRow.addView(textView);
//
//            // Add the TableRow to the TableLayout
//            tableLayout.addView(tableRow);
//        }

        TableLayout tableLayout = findViewById(R.id.table3);

        String[] rowData = {"Root Touch-up", "Black Hair", "Light Black", "Natural Black", "Mehandi"};

        for (String rowDatum : rowData) {
            TableRow tableRow = new TableRow(this);
            tableRow.setPadding(5, 5, 5, 5);


            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            textView.setGravity(Gravity.LEFT);
            textView.setPadding(10, 10, 10, 10);
            textView.setTextColor(ContextCompat.getColor(this, R.color.white)); // Replace with your color resource

            textView.setText(rowDatum);

            tableRow.addView(textView);

            tableLayout.addView(tableRow);
        }

        TableLayout tableLayout2 = findViewById(R.id.table4);
        String[] rowData2 = {"Very Light Blond", "Red", "Cherry Red", "Blond", "Ash", "Peacock", "Global + Highlight"};

        for (int i = 0; i < rowData2.length; i++) {
            // Create a new TableRow
            TableRow tableRow = new TableRow(this);

//            tableRow.setPadding(5,5,5,5);

            // Create a new TextView
            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            textView.setGravity(Gravity.LEFT);
            textView.setPadding(10, 10, 10, 10);
            textView.setTextColor(ContextCompat.getColor(this, R.color.white)); // Replace with your color resource

            // Set the text for the TextView from the data array
            textView.setText(rowData2[i]);
            // Add the TextView to the TableRow
            tableRow.addView(textView);

            // Add the TableRow to the TableLayout
            tableLayout2.addView(tableRow);
        }

        TableLayout tableLayout3 = findViewById(R.id.table5);

        String[] rowData3 = {"Very Light Blond", "Red", "Cherry Red", "Blond", "Ash", "Peacock", "Global + Ombre"};

        for (String rowdatas : rowData3) {
            TableRow tableRow = new TableRow(this);
            tableRow.setPadding(5, 5, 5, 5);


            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            textView.setGravity(Gravity.LEFT);
            textView.setPadding(10, 10, 10, 10);
            textView.setTextColor(ContextCompat.getColor(this, R.color.white)); // Replace with your color resource

            textView.setText(rowdatas);

            tableRow.addView(textView);

            tableLayout3.addView(tableRow);
        }

        TableLayout tableLayout4 = findViewById(R.id.table6);

        String[] rowData4 = {"Straightning", "Smoothening", "Keratin "};

        for (String rowdatas : rowData4) {
            TableRow tableRow = new TableRow(this);
            tableRow.setPadding(5, 5, 5, 5);


            TextView textView = new TextView(this);
            textView.setLayoutParams(new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            textView.setGravity(Gravity.LEFT);
            textView.setPadding(10, 10, 10, 10);
            textView.setTextColor(ContextCompat.getColor(this, R.color.white)); // Replace with your color resource

            textView.setText(rowdatas);

            tableRow.addView(textView);

            tableLayout4.addView(tableRow);
        }
    }
}