package com.example.myapplication;

import java.util.List;

public interface BookRepository {
    // Get a book by its ID
    Book getBookById(int bookId);

    // Get all books in the system
    List<Book> getAllBooks();

    // Add a new book
    void addBook(Book book);

    // Update an existing book
    void updateBook(Book book);

    // Delete a book by its ID
    void deleteBook(int bookId);

    // Search books by title
    List<Book> searchBooksByTitle(String title);

    // Get top-rated books (e.g., for recommendations)
    List<Book> getTopRatedBooks(int limit);
}
