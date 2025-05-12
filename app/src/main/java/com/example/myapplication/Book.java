package com.example.myapplication;

public class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private final String genre;
    private double averageRating;

    public Book(int bookId, String title, String author, String genre, double averageRating) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
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
    public String getGenre() {
        return genre;
    }
    public double getAverageRating() {
        return averageRating;
    }
    //setter
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
