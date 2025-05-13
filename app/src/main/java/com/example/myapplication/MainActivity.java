package com.example.myapplication;

import android.os.Bundle;
import com.example.myapplication.ValidationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            EditText usernameInput = findViewById(R.id.usernameEditText);
            EditText passwordInput = findViewById(R.id.passwordEditText);
            Button loginButton = findViewById(R.id.loginButton);

            loginButton.setOnClickListener(v -> {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString();

                if (!ValidationUtils.isValidUsername(username)) {
                    Toast.makeText(this, "Invalid username (3-15 characters, letters/numbers/underscores only)", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!ValidationUtils.isValidPassword(password)) {
                    Toast.makeText(this, "Password must be 8+ characters with upper/lowercase, digit, and special character", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            });
        }



        });
    }



}