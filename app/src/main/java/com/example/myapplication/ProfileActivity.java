package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView profileUsername, profileEmail;
    Button editProfileButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        try {
            // ActionBar geri düğmesi
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
            }

            // UI öğelerini bağla
            profileUsername = findViewById(R.id.profileUsername);
            profileEmail = findViewById(R.id.usernameId);
            editProfileButton = findViewById(R.id.editProfileButton);
            logoutButton = findViewById(R.id.logoutButton);

            if (profileUsername == null || profileEmail == null || editProfileButton == null || logoutButton == null) {
                throw new NullPointerException("Bazı view'ler bulunamadı. XML dosyanızı kontrol edin.");
            }

            // Intent verisi al
            String username = getIntent().getStringExtra("username");
            String userId = getIntent().getStringExtra("user id");

            if (username == null || userId == null) {
                throw new IllegalArgumentException("Kullanıcı bilgileri eksik geldi.");
            }

            profileUsername.setText("Username: " + username);
            profileEmail.setText("user id: " + userId);

            editProfileButton.setOnClickListener(v -> {
                // Gelecekte edit ekranı eklenecekse buraya yönlendirme konulabilir.
                Toast.makeText(this, "Profil düzenleme yakında eklenecek.", Toast.LENGTH_SHORT).show();
            });

            logoutButton.setOnClickListener(v -> {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
            });

        } catch (IllegalArgumentException e) {
            Toast.makeText(this, "Kullanıcı bilgileri alınamadı. Ana sayfaya dönülüyor.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Bir hata oluştu: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

