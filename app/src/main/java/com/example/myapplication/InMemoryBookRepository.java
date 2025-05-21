package com.example.myapplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryBookRepository implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    public InMemoryBookRepository() {
        // örnek kitaplar
        books.add(new Book(1, "Harry Potter", "J.K. Rowling", List.of("Fantasy"), 4.5));
        books.add(new Book(2, "The Hobbit", "J.R.R. Tolkien", List.of("Fantasy"), 4.7));
        books.add(new Book(3, "Clean Code", "Robert C. Martin", List.of("Programming"), 4.8));
    }

    @Override
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == updatedBook.getBookId()) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    @Override
    public void deleteBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getTopRatedBooks(int limit) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getAverageRating).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}


