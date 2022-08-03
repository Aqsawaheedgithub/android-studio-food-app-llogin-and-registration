package com.example.leftyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity2 extends AppCompatActivity {

    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);

        button3 =  findViewById(R.id.button3);
        button3.setOnClickListener(this::onClick);

    }

    private void onClick(View v) {
        Toast.makeText(AddActivity2.this, "send food details to Ngos", Toast.LENGTH_LONG).show();
        Intent intent;intent = new Intent(AddActivity2.this, fooddetailbyusersActivity2.class);
        startActivity(intent);
    }
}
