package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.myapplication.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String username = getIntent().getStringExtra("username");
        String userId = getIntent().getStringExtra("user id");

        android.util.Log.d("HomeActivity", "Username received: " + username);
        android.util.Log.d("HomeActivity", "User ID received: " + userId);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        /*Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        intent.putExtra("username", getIntent().getStringExtra("username"));
        intent.putExtra("user id", getIntent().getStringExtra("user id"));
        startActivity(intent);
         */

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                return true;
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                return true;
            } else if (id == R.id.nav_profile) {
                Intent profileIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                profileIntent.putExtra("username", getIntent().getStringExtra("username"));
                profileIntent.putExtra("user id", getIntent().getStringExtra("user id"));
                startActivity(profileIntent);
                return true;
            }

            return false;
        });




        logoutButton = findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to login
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close home activity
            }
        });
    }
}

