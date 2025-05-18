package com.example.myapplication;

public class Rating {
    private int ratingId;
    private int userId;
    private int bookId;
    private int score; // 1-5
    private String comment;

    public Rating(int ratingId, int userId, int bookId, int score, String comment) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("Puan 1 ile 5 arasında olmalıdır.");
        }
        if (comment == null) {
            throw new IllegalArgumentException("Yorum null olamaz.");
        }

        this.ratingId = ratingId;
        this.userId = userId;
        this.bookId = bookId;
        this.score = score;
        this.comment = comment;
    }

    // Getters
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

    public String getComment() {
        return comment;
    }

    // Setters
    public void setScore(int score) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("Puan yalnızca 1 ile 5 arasında olabilir.");
        }
        this.score = score;
    }

    public void setComment(String comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Yorum null olamaz.");
        }
        this.comment = comment;
    }
}

