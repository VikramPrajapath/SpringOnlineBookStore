package com.tavant.spring.core.SpringOnlineBookStore.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int userId;
    private List<Book> books;

    public Cart(int userId) {
        this.userId = userId;
        this.books = new ArrayList<>();
    }

    // Add a book to the cart
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the cart
    public void removeBook(Book book) {
        books.remove(book);
    }

    // View items in the cart
    public List<Book> viewBooks() {
        return books;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

