package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtFullName, txtUsername, txtPassword;
    private Button btnSignUp, btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 1. Connect UI components
        txtFullName = findViewById(R.id.txtSignUpFullName);
        txtUsername = findViewById(R.id.txtSignUpUsername);
        txtPassword = findViewById(R.id.txtSignUpPassword); // This works even for PasswordEditText
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignUpSignIn);

        // 2. Sign Up button logic
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = txtFullName.getText().toString().trim();
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: Send data to backend or save in database
                    Toast.makeText(RegisterActivity.this, "Account created!", Toast.LENGTH_SHORT).show();

                    // Optionally go to login screen
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        // 3. "Have an account? Log in." button
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to LoginActivity
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
