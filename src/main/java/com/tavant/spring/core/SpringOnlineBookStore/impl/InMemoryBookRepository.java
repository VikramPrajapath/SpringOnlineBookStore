package com.tavant.spring.core.SpringOnlineBookStore.impl;

import java.util.ArrayList;
import java.util.List;
import com.tavant.spring.core.SpringOnlineBookStore.entity.Book;
import com.tavant.spring.core.SpringOnlineBookStore.repo.BookRepository;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
    }

    @Override
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                return;
            }
        }
        // If the book doesn't exist, add it
        books.add(book);
    }

    @Override
    public Book getBookById(int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
