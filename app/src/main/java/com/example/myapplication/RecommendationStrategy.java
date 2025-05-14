package com.example.myapplication;

import java.util.List;

//strategy design pattern
public interface RecommendationStrategy {
    List<Book> recommend(User user, List<Book> allBooks, List<Rating> allRatings);
}
