package com.example.leftyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity2 extends AppCompatActivity {
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);


        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(NextActivity2.this, AddActivity2.class);
            startActivity(intent);
        });
        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(NextActivity2.this, checkfooddonationActivity2.class);
            startActivity(intent);

        });

    }
}