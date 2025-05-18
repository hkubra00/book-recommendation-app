package com.example.myapplication;

public class Comment {
    private int reviewId;
    private int userId;
    private int bookId;
    private String comment;

    public Comment(int reviewId, int userId, int bookId, String comment) {
        if (reviewId <= 0 || userId <= 0 || bookId <= 0) {
            throw new IllegalArgumentException("ID değerleri pozitif olmalıdır.");
        }
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("Yorum boş olamaz.");
        }

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
        if (reviewId <= 0) {
            throw new IllegalArgumentException("Review ID pozitif olmalıdır.");
        }
        this.reviewId = reviewId;
    }

    public void setUserId(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID pozitif olmalıdır.");
        }
        this.userId = userId;
    }

    public void setBookId(int bookId) {
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID pozitif olmalıdır.");
        }
        this.bookId = bookId;
    }

    public void setComment(String comment) {
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("Yorum boş olamaz.");
        }
        this.comment = comment;
    }
}
