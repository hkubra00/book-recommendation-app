package com.example.myapplication.factory;

import com.example.myapplication.Book;

import java.util.List;

public class BookFactory {

    public static Book createBook(int bookId, String title, String author, List<String> genres) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty.");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }

        if (genres == null || genres.isEmpty()) {
            throw new IllegalArgumentException("At least one genre must be specified.");
        }

        return new Book(bookId, title, author, genres, 0.0); // default rating
    }
}
