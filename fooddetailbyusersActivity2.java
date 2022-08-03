package com.example.leftyapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class fooddetailbyusersActivity2 extends AppCompatActivity   implements AdapterView.OnItemSelectedListener    {

    private TextView tvTime;

    private TextView tvSelectDate;
    private EditText etSelectDate;
    Button button7, btn17;
    Button button8;
    Button button9;
    Button button5;
    EditText  location;
    EditText editTextTextPersonName;
    EditText foodtypes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetailbyusers2);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            getIntent().setData(Uri.parse("geo:47.4925,19.0513"));
            Intent chooser = Intent.createChooser(intent,"Launch Maps");
            startActivity(chooser);
        });


        location = (EditText) findViewById(R.id.location);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        foodtypes = (EditText) findViewById(R.id.foodtypes);

        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(v -> {
            Intent intent = new Intent(fooddetailbyusersActivity2.this, AcceptActivity2.class);
            startActivity(intent);
        });

        Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        tvTime = findViewById(R.id.tvTime);
        tvTime.setOnClickListener(v -> {
            @SuppressLint("SetTextI18n") TimePickerDialog timePickerDialog = new TimePickerDialog(fooddetailbyusersActivity2.this, (view, hourOfDay, minute) -> {
                Calendar calendar = Calendar.getInstance();
                calendar.set(0,0,0, hourOfDay, minute);

                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
                tvTime.setText("Time: "+sdf.format(calendar.getTime()));

            },12,0,false);
            timePickerDialog.show();
        });


        tvSelectDate = findViewById(R.id.tvSelectDate);
        etSelectDate = findViewById(R.id.etSelectDate);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvSelectDate.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(fooddetailbyusersActivity2.this, (view, year1, month1, dayOfMonth) -> {
                month1 = month1 +1;
                String date = day+"/"+ month1 +"/"+ year1;
                tvSelectDate.setText(date);

            },year, month,day);
            dialog.show();
        });
        etSelectDate.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(fooddetailbyusersActivity2.this, (view, year12, month12, dayOfMonth) -> {
                month12 = month12 +1;
                String date = dayOfMonth+"/"+ month12 +"/"+ year12;
                etSelectDate.setText(date);

            },year, month,day);
            dialog.show();
        });

        btn17 = findViewById(R.id.btn17);
        btn17.setOnClickListener(v ->
                Toast.makeText(fooddetailbyusersActivity2.this,"confirmed",Toast.LENGTH_LONG).show());
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v ->
                Toast.makeText(fooddetailbyusersActivity2.this,"confirmed",Toast.LENGTH_LONG).show());
        button8 = findViewById(R.id.button8);

        button8.setOnClickListener(v ->
                Toast.makeText(fooddetailbyusersActivity2.this,"confirmed",Toast.LENGTH_LONG).show());

        button9 =  findViewById(R.id.button9);
        button9.setOnClickListener(v -> {
            Toast.makeText(fooddetailbyusersActivity2.this,"Submitted to NGOs",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(fooddetailbyusersActivity2.this, logoutActivity2.class);
            startActivity(intent);

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}