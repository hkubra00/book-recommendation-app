package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private BookRepository bookRepository; // Senin interface'in

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //UI bileşenlerini bağlama
        searchInput = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);

        //BookRepository (interfaceolduğu için implement eden sınıf kullanıldı)
        bookRepository = new InMemoryBookRepository();

        //buton dinleyicisi
        searchButton.setOnClickListener(v -> {
            try {
                String keyword = searchInput.getText().toString().trim();

                if (keyword.isEmpty()) {
                    Toast.makeText(this, "Lütfen bir arama terimi girin", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Book> results = bookRepository.searchBooksByTitle(keyword);

                // Arama sonucu işle
                Toast.makeText(this, results.size() + " sonuç bulundu", Toast.LENGTH_SHORT).show();
                // TODO: Sonuçları bir RecyclerView ile göster

            } catch (NullPointerException e) {
                Toast.makeText(this, "Arama sırasında hata oluştu (Null)", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Bir hata oluştu: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

