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
import org.mindrot.jbcrypt.BCrypt;

public class MainActivity extends AppCompatActivity {

    private UserRepository userRepository;  // Declare the UserRepository to fetch data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userRepository = new UserRepository();  // Initialize the UserRepository

        EditText usernameInput = findViewById(R.id.username);
        EditText passwordInput = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(v -> {
            try {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Validate input
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Simulated validation (could be a separate utility class for validation)
                if (!ValidationUtils.isValidUsername(username)) {
                    Toast.makeText(MainActivity.this, "Invalid username (3–15 characters, letters/numbers/underscores only)", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!ValidationUtils.isValidPassword(password)) {
                    Toast.makeText(MainActivity.this, "Password must be 8+ characters with upper/lowercase, digit, and special character", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Fetch user from the database
                User user = userRepository.getUserByUsername(username);

                if (user != null && BCrypt.checkpw(password, user.getUserPassword())) {
                    // Login successful
                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                    // Pass user data to the next activity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("user_id", String.valueOf(user.getUserId()));  // Send user ID
                    startActivity(intent);
                    finish();

                } else {
                    // Invalid username or password
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "An error occurred: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}