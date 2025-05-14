package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView profileUsername, profileEmail;
    Button editProfileButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileUsername = findViewById(R.id.profileUsername);
        profileEmail = findViewById(R.id.usernameId);
        editProfileButton = findViewById(R.id.editProfileButton);
        logoutButton = findViewById(R.id.logoutButton);

        // Sample static user info (could be replaced with real data)
        String username = getIntent().getStringExtra("username");
        String user_id = getIntent().getStringExtra("user id");

        profileUsername.setText("Username: " + username);
        profileEmail.setText("user id: " + user_id);



        editProfileButton.setOnClickListener(v -> {
            // TODO: Navigate to EditProfileActivity (you can create this later)
        });

        logoutButton.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            finish();
        });
    }
}
