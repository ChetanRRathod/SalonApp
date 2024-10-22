package com.example.myapplication;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.Calendar;
public class Appointment extends Activity {

    private EditText nameEditText, mobileEditText, dateEditText;
    private Button bookAppointmentButton;
    private Calendar calendar;
    private int year, month, day;
    private Spinner treatmentSpinner,timeSpinner;
    private SQLiteDatabase db;

    private ListView appointmentsListView;
    private ArrayAdapter<String> appointmentsAdapter;
    private ArrayList<String> appointmentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        nameEditText = findViewById(R.id.editName);
        mobileEditText = findViewById(R.id.editMobile);
//        timeEditText = findViewById(R.id.editTime);
        dateEditText = findViewById(R.id.editDate);
        treatmentSpinner = findViewById(R.id.treatmentSpinner);
        timeSpinner=findViewById(R.id.timeSpinner);
        bookAppointmentButton = findViewById(R.id.bookAppointmentButton);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        db = openOrCreateDatabase("AppointmentsDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Appointments (Name TEXT, Mobile TEXT, Time TEXT, Date TEXT, Treatment TEXT);");

        String[] timeOptions = getResources().getStringArray(R.array.time_options);
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeOptions);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        String[] treatmentOptions =getResources().getStringArray(R.array.treatment_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, treatmentOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        treatmentSpinner.setAdapter(adapter);

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                showDatePickerDialog();

            }
        });

        bookAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, mobile, time, date, treatment;
                ContentValues values;
                name = nameEditText.getText().toString().trim();
                mobile = mobileEditText.getText().toString().trim();
                time = timeSpinner.getSelectedItem().toString();
                date = dateEditText.getText().toString().trim();
                treatment = treatmentSpinner.getSelectedItem().toString();

                time = timeSpinner.getSelectedItem().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mobile) || TextUtils.isEmpty(date) || TextUtils.isEmpty(time)) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mobile) || TextUtils.isEmpty(time) || TextUtils.isEmpty(date) ) {
                    Toast.makeText(getApplicationContext(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isValidUsername(name)) {
                    Toast.makeText(getApplicationContext(), "Invalid name. Please use only alphabetic characters.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mobile.length() != 10 || !TextUtils.isDigitsOnly(mobile)) {
                    Toast.makeText(getApplicationContext(), "Invalid mobile number. Please enter a 10-digit number.", Toast.LENGTH_SHORT).show();
                    return;
                }

                values = new ContentValues();
                values.put("Name", name);
                values.put("Mobile", mobile);
                values.put("Time", time);
                values.put("Date", date);
                values.put("Treatment", treatment);

                long result = db.insert("Appointments", null, values);

                if (result != -1) {
                    Toast.makeText(getApplicationContext(), "Appointment booked successfully!", Toast.LENGTH_SHORT).show();
                    nameEditText.setText("");
                    mobileEditText.setText("");
                    dateEditText.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Error booking appointment.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        appointmentsList = new ArrayList<>();
        appointmentsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appointmentsList);
        appointmentsListView = findViewById(R.id.appointmentsListView);
        appointmentsListView.setAdapter(appointmentsAdapter);

        // Load existing appointments when the activity starts
        loadAppointments();

        ImageButton back_1 = findViewById(R.id.back_1);

        back_1.setOnClickListener(view -> {
//            Intent i = new Intent(MainActivity2.this, home.class);
            finish();
        });

        ImageButton homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Appointment.this, home.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finishAffinity();
            }
        });


    }

    private boolean isValidUsername(String username) {
        // Regular expression to check if the username contains only alphabetic characters
        String regex = "^[a-zA-Z ]+$";
        return username.matches(regex);
    }
    private void showDatePickerDialog() {
        // Get the current date
        final Calendar currentDate = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        year = selectedYear;
                        month = selectedMonth;
                        day = selectedDay;

                        // Check if the selected date is not in the past
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, day);

                        if (selectedDate.after(currentDate) || selectedDate.equals(currentDate)) {
                            // Date is valid
                            updateDateEditText();
                        } else {
                            // Date is in the past
                            Toast.makeText(Appointment.this, "Please select a future date", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                year,
                month,
                day
        );

        // Set the minimum date to the current date
        datePickerDialog.getDatePicker().setMinDate(currentDate.getTimeInMillis());

        // Show the date picker dialog
        datePickerDialog.show();
    }
    private void loadAppointments() {
        // Clear the list before loading to avoid duplicates
        appointmentsList.clear();

        // Query the database to get all appointments
        Cursor cursor = db.rawQuery("SELECT * FROM Appointments", null);

        // Check if the cursor has columns
        if (cursor.getColumnCount() > 0) {
            // Iterate through the columns and get their indices
            int nameIndex = cursor.getColumnIndex("Name");
            int timeIndex = cursor.getColumnIndex("Time");
            int dateIndex = cursor.getColumnIndex("Date");
            int treatmentIndex = cursor.getColumnIndex("Treatment");

            // Check if the column indices are valid
            if (nameIndex >= 0 && timeIndex >= 0 && dateIndex >= 0 && treatmentIndex >= 0) {
                // Move to the first row of the result set
                if (cursor.moveToFirst()) {
                    do {
                        // Retrieve values from cursor using column indices
                        String name = cursor.getString(nameIndex);
                        String time = cursor.getString(timeIndex);
                        String date = cursor.getString(dateIndex);
                        String treatment = cursor.getString(treatmentIndex);

                        // Format the appointment details
                        String appointmentDetails = "Name: " + name + "\nTime: " + time + "\nDate: " + date + "\nTreatment: " + treatment;

                        // Add the formatted details to the list
                        appointmentsList.add(appointmentDetails);
                    } while (cursor.moveToNext());

                    // Notify the adapter that the data set has changed
                    appointmentsAdapter.notifyDataSetChanged();
                }
            } else {
                // Log an error or show a toast indicating that columns are missing
                Toast.makeText(this, "Columns are missing in the cursor.", Toast.LENGTH_SHORT).show();
            }
        }

        // Close the cursor to avoid memory leaks
        cursor.close();
    }



    private void updateDateEditText() {
        dateEditText.setText(String.format("%02d/%02d/%04d", month + 1, day, year));
    }
}