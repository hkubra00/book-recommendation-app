package com.example.myapplication.factory;

import com.example.myapplication.Rating;

public class RatingFactory {

    public static Rating createRating(int ratingId, int userId, int bookId, int score, String comment) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("Score must be between 1 and 5.");
        }

        if (comment == null) {
            comment = ""; // allow empty, but not null
        }

        return new Rating(ratingId, userId, bookId, score, comment);
    }
}
