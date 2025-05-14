package com.example.myapplication;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationEngine {
    public List<Book> getRecommendations(User user, List<Book> allBooks, List<Rating> allRatings) {
        int userId = user.getUserId();

        // Step 1: Get ratings by this user
        List<Rating> userRatings = allRatings.stream()
                .filter(r -> r.getUserId() == userId)
                .collect(Collectors.toList());

        // Step 2: Count genre preferences based on high scores (4 or 5)
        Map<String, Integer> genrePreferenceMap = new HashMap<>();
        for (Rating rating : userRatings) {
            if (rating.getScore() >= 4) {
                Book ratedBook = findBookById(allBooks, rating.getBookId());
                if (ratedBook != null) {
                    for (String genre : ratedBook.getGenres()) {
                        genrePreferenceMap.compute(genre, (key, value) -> (value == null ? 1 : value + 1));
                    }
                }
            }
        }

        // Step 3: Get IDs of books the user already rated
        Set<Integer> ratedBookIds = userRatings.stream()
                .map(Rating::getBookId)
                .collect(Collectors.toSet());

        // Step 4: Score unrated books based on genre matches
        Map<Book, Integer> bookScores = new HashMap<>();
        for (Book book : allBooks) {
            if (!ratedBookIds.contains(book.getBookId())) {
                int score = 0;
                for (String genre : book.getGenres()) {
                    Integer preference = genrePreferenceMap.get(genre);
                    score += (preference != null) ? preference : 0;
                }
                if (score > 0) {
                    bookScores.put(book, score);
                }
            }
        }

        // Step 5: Sort books by score (and optionally by average rating as tiebreaker)
        return bookScores.entrySet().stream()
                .sorted((e1, e2) -> {
                    int cmp = Integer.compare(e2.getValue(), e1.getValue());
                    if (cmp == 0) {
                        return Double.compare(e2.getKey().getAverageRating(), e1.getKey().getAverageRating());
                    }
                    return cmp;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private Book findBookById(List<Book> books, int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
