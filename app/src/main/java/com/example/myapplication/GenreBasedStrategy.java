package com.example.myapplication;

import java.util.*;
import java.util.stream.Collectors;

public class GenreBasedStrategy implements RecommendationStrategy {

    @Override
    public List<Book> recommend(User user, List<Book> allBooks, List<Rating> allRatings) {
        List<Book> recommendedBooks = new ArrayList<>();

        try {
            if (user == null || allBooks == null || allRatings == null) {
                throw new IllegalArgumentException("Kullanıcı veya veri listeleri null olamaz.");
            }

            int userId = user.getUserId();

            List<Rating> userRatings = allRatings.stream()
                    .filter(r -> r.getUserId() == userId)
                    .collect(Collectors.toList());

            Map<String, Integer> genrePreferenceMap = new HashMap<>();
            for (Rating rating : userRatings) {
                if (rating.getScore() >= 4) {
                    Book ratedBook = findBookById(allBooks, rating.getBookId());
                    if (ratedBook != null) {
                        for (String genre : ratedBook.getGenres()) {
                            genrePreferenceMap.compute(genre, (k, v) -> (v == null) ? 1 : v + 1);
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
                    for (String genre : book.getGenres()) {
                        score += genrePreferenceMap.getOrDefault(genre, 0);
                    }
                    if (score > 0) {
                        bookScores.put(book, score);
                    }
                }
            }

            recommendedBooks = bookScores.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int cmp = Integer.compare(e2.getValue(), e1.getValue());
                        if (cmp == 0) {
                            return Double.compare(e2.getKey().getAverageRating(), e1.getKey().getAverageRating());
                        }
                        return cmp;
                    })
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            System.err.println("Geçersiz argüman: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Tavsiye algoritmasında bir hata oluştu: " + e.getMessage());
            e.printStackTrace(); // Geliştirme sürecinde faydalı olur
        }

        return recommendedBooks;
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

