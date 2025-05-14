package com.example.myapplication;

public class Comment {
    private int reviewId;
    private int userId;
    private int bookId;
    private String comment;


    public Comment(int reviewId, int userId, int bookId, String comment) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.bookId = bookId;
        this.comment = comment;
    }

    // Getters
    public int getReviewId() {
        return reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getComment() {
        return comment;
    }

    // Setters
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

}
