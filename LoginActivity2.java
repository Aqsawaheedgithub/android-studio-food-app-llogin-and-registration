package com.example.leftyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity2 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        Button btnLogin = findViewById(R.id.login);
        TextView textRegister = findViewById(R.id.text_register);

        btnLogin.setOnClickListener(v -> login());
        textRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity2.this, FirebaseRegisterActivity2.class);
            startActivity(intent);
        });
    }

    private void login()
    {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (user.isEmpty())
        {
            email.setError("Email can not be empty");
        }
        if (pass.isEmpty())
        {
            password.setError("Password can not be empty");
        }
        else
        {
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(task -> {
                if (task.isSuccessful())
                {
                    Toast.makeText(LoginActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity2.this, NextActivity2.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity2.this, "Login Failed"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}