package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.example.myapplication.ValidationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        EditText usernameInput = findViewById(R.id.usernameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginBtn = findViewById(R.id.loginButton);

        // Set click listener on the button
        loginBtn.setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!ValidationUtils.isValidUsername(username)) {
                Toast.makeText(MainActivity.this, "Invalid username (3–15 characters, letters/numbers/underscores only)", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!ValidationUtils.isValidPassword(password)) {
                Toast.makeText(MainActivity.this, "Password must be 8+ characters with upper/lowercase, digit, and special character", Toast.LENGTH_SHORT).show();
                return;
            }

            // Simulated login
            if (username.equals("admin") && password.equals("1234")) {
                Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("user id", "user id");
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
    }



}