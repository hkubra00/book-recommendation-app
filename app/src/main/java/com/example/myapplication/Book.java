package com.example.myapplication;

import java.util.List;

public class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private final List<String> genres;
    private double averageRating;

    public Book(int bookId, String title, String author, List<String> genres, double averageRating) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Kitap başlığı boş olamaz.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Yazar adı boş olamaz.");
        }
        if (genres == null || genres.isEmpty()) {
            throw new IllegalArgumentException("Tür listesi boş olamaz.");
        }
        if (averageRating < 0 || averageRating > 5) {
            throw new IllegalArgumentException("Ortalama puan 0 ile 5 arasında olmalıdır.");
        }

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.averageRating = averageRating;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getGenres() {
        return genres;
    }

    public double getAverageRating() {
        return averageRating;
    }

    // Setter
    public void setAverageRating(double averageRating) {
        if (averageRating < 0 || averageRating > 5) {
            throw new IllegalArgumentException("Ortalama puan 0 ile 5 arasında olmalıdır.");
        }
        this.averageRating = averageRating;
    }
}

