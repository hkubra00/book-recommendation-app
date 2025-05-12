package com.example.myapplication;

public class Rating {
    private int ratingId;
    private int userId;
    private int bookId;
    private int score; // 1-5
    private String comment;

    public Rating(int ratingId, int userId, int bookId, int score, String comment) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.bookId = bookId;
        this.score = score;
        this.comment = comment;
    }
    // Getters and setters
    public int getRatingId() {
        return ratingId;
    }
    public int getUserId() {
        return userId;
    }
    public int getBookId() {
        return bookId;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
