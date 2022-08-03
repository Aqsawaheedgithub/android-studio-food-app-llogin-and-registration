package com.example.leftyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainmainActivity2 extends AppCompatActivity {



    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmain2);

        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(v -> {
            Intent intent = new Intent(MainmainActivity2.this, NextActivity2.class);
            startActivity(intent);
        });

        mAuth = FirebaseAuth.getInstance();
        Button btnLogout = findViewById(R.id.btnlogout);
        btnLogout.setOnClickListener(v -> logout());
    }
    @Override

    public void onStart()
    {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            Intent intent = new Intent(MainmainActivity2.this, LoginActivity2.class);
            startActivity(intent);
        }

    }

    public void logout()
    {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainmainActivity2.this, LoginActivity2.class);
        startActivity(intent);
    }
}