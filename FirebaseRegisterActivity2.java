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

public class FirebaseRegisterActivity2 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_register2);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        Button btnRegister = findViewById(R.id.register);
        TextView textLogin = findViewById(R.id.text_login);

        btnRegister.setOnClickListener(v -> FirebaseRegister());
        textLogin.setOnClickListener(v -> {
            Intent intent = new Intent(FirebaseRegisterActivity2.this, LoginActivity2.class);
            startActivity(intent);
        });
    }

    private void FirebaseRegister()
    {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(user.isEmpty())
        {
            email.setError("Email can not be empty");
        }
        if(pass.isEmpty())
        {
            password.setError("Password can not be empty");
        }
        else
        {
           mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(task -> {
               if (task.isSuccessful())
               {
                   Toast.makeText(FirebaseRegisterActivity2.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(FirebaseRegisterActivity2.this, MainmainActivity2.class);
                   startActivity(intent);

               }
               else
               {
                   Toast.makeText(FirebaseRegisterActivity2.this, "Registration Failed"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
               }
           });
        }

    }
}