package com.example.myapplication;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendationEngine {

    public List<Book> getRecommendations(User user, List<Book> allBooks, List<Rating> allRatings) {
        if (user == null) {
            throw new IllegalArgumentException("Kullanıcı nesnesi null olamaz.");
        }
        if (allBooks == null || allRatings == null) {
            throw new IllegalArgumentException("Kitaplar ve derecelendirmeler null olamaz.");
        }

        int userId = user.getUserId();

        List<Rating> userRatings = allRatings.stream()
                .filter(r -> r.getUserId() == userId)
                .collect(Collectors.toList());

        Map<String, Integer> genrePreferenceMap = new HashMap<>();
        for (Rating rating : userRatings) {
            if (rating.getScore() >= 4) {
                Book ratedBook = findBookById(allBooks, rating.getBookId());
                if (ratedBook != null && ratedBook.getGenres() != null) {
                    for (String genre : ratedBook.getGenres()) {
                        genrePreferenceMap.compute(genre, (key, value) -> (value == null ? 1 : value + 1));
                    }
                }
            }
        }

        Set<Integer> ratedBookIds = userRatings.stream()
                .map(Rating::getBookId)
                .collect(Collectors.toSet());

        Map<Book, Integer> bookScores = new HashMap<>();
        for (Book book : allBooks) {
            if (!ratedBookIds.contains(book.getBookId())) {
                int score = 0;
                if (book.getGenres() != null) {
                    for (String genre : book.getGenres()) {
                        score += genrePreferenceMap.getOrDefault(genre, 0);
                    }
                }
                if (score > 0) {
                    bookScores.put(book, score);
                }
            }
        }

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
        if (books == null) return null;
        for (Book book : books) {
            if (book != null && book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}

