package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //EditText searchInput = findViewById(R.id.searchInput);
        //Button searchButton = findViewById(R.id.searchButton);
        //
        //searchButton.setOnClickListener(v -> {
        //    try {
        //        String keyword = searchInput.getText().toString().trim();
        //
        //        if (keyword.isEmpty()) {
        //            Toast.makeText(SearchActivity.this, "Lütfen bir arama terimi girin", Toast.LENGTH_SHORT).show();
        //            return;
        //        }
        //
        //        // Örneğin kitap arama işlemi
        //        List<Book> results = bookRepository.searchBooksByTitle(keyword); // burası veritabanına bağlanabilir
        //        // sonucu göster...
        //
        //    } catch (NullPointerException e) {
        //        Toast.makeText(SearchActivity.this, "Arama sırasında hata oluştu (Null)", Toast.LENGTH_SHORT).show();
        //    } catch (Exception e) {
        //        Toast.makeText(SearchActivity.this, "Bir hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        //    }
        //});
    }
}
