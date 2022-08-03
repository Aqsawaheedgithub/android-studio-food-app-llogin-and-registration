package com.example.leftyapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class checkfooddonationActivity2 extends AppCompatActivity {
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkfooddonation2);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.youhaveanewmessage);


        button4 =findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            Toast.makeText(checkfooddonationActivity2.this,"food checked from resturants",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(checkfooddonationActivity2.this,fooddetailbyusersActivity2.class);
            startActivity(intent);
            mediaPlayer.start();

        });
    }
}