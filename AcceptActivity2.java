package com.example.leftyapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AcceptActivity2 extends AppCompatActivity {

    private TextView tvSelectDate;
    private EditText etSelectDate;

    private TextView tvTime;

    public Button button10;
    public Button button11;
    public Button button12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept2);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.accepted);
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.rejected);

        tvSelectDate = findViewById(R.id.tvSelectDate);
        etSelectDate = findViewById(R.id.etSelectDate);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvSelectDate.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(AcceptActivity2.this, (view, year1, month1, dayOfMonth) -> {
                month1 = month1 + 1;
                String date = day + "/" + month1 + "/" + year1;
                tvSelectDate.setText(date);

            }, year, month, day);
            dialog.show();
        });
        etSelectDate.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(AcceptActivity2.this, (view, year12, month12, dayOfMonth) -> {
                month12 = month12 + 1;
                String date = dayOfMonth + "/" + month12 + "/" + year12;
                etSelectDate.setText(date);

            }, year, month, day);
            dialog.show();
        });

        tvTime = findViewById(R.id.tvTime);
        tvTime.setOnClickListener(v -> {
            @SuppressLint("SetTextI18n") TimePickerDialog timePickerDialog = new TimePickerDialog(AcceptActivity2.this, (view, hourOfDay, minute) -> {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(0, 0, 0, hourOfDay, minute);

                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
                tvTime.setText("Time: " + sdf.format(calendar1.getTime()));

            }, 12, 0, false);
            timePickerDialog.show();
        });


        button10 = findViewById(R.id.button10);
        button10.setOnClickListener(v ->
                Toast.makeText(AcceptActivity2.this, "Food accepted by volunteers", Toast.LENGTH_LONG).show());
        mediaPlayer.start();
        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(v -> Toast.makeText(AcceptActivity2.this, "Reject  food ", Toast.LENGTH_LONG).show());
        mediaPlayer1.start();
        button12 = findViewById(R.id.button12);
        button12.setOnClickListener(v -> {
            Toast.makeText(AcceptActivity2.this, "selected  ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AcceptActivity2.this, logoutActivity2.class);
            startActivity(intent);
        });
    }


}