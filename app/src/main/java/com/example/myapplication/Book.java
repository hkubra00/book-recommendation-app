package com.example.myapplication;

import java.util.List;

public class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private final List<String> genres;
    private double averageRating;

    public Book(int bookId, String title, String author, List<String> genres, double averageRating) {
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
    //setter
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
