package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_home);

            String username = getIntent().getStringExtra("username");
            String userId = getIntent().getStringExtra("user id");

            android.util.Log.d("HomeActivity", "Username received: " + username);
            android.util.Log.d("HomeActivity", "User ID received: " + userId);

            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

            bottomNavigationView.setOnItemSelectedListener(item -> {
                try {
                    int id = item.getItemId();

                    if (id == R.id.nav_home) {
                        return true;
                    } else if (id == R.id.nav_search) {
                        startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                        return true;
                    } else if (id == R.id.nav_profile) {
                        Intent profileIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                        profileIntent.putExtra("username", username);
                        profileIntent.putExtra("user id", userId);
                        startActivity(profileIntent);
                        return true;
                    }

                } catch (Exception e) {
                    android.util.Log.e("HomeActivity", "Bottom nav işleminde hata: " + e.getMessage(), e);
                }

                return false;
            });

            logoutButton = findViewById(R.id.btnLogout);

            if (logoutButton != null) {
                logoutButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // Close home activity
                        } catch (Exception e) {
                            android.util.Log.e("HomeActivity", "Çıkış yapılırken hata oluştu: " + e.getMessage(), e);
                        }
                    }
                });
            } else {
                android.util.Log.e("HomeActivity", "logoutButton bulunamadı. XML dosyasını kontrol et.");
            }

        } catch (Exception e) {
            android.util.Log.e("HomeActivity", "onCreate sırasında hata oluştu: " + e.getMessage(), e);
        }
    }
}


