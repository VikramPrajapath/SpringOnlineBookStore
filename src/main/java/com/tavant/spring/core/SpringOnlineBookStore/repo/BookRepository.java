package com.tavant.spring.core.SpringOnlineBookStore.repo;

import java.util.List;

import com.tavant.spring.core.SpringOnlineBookStore.entity.Book;

public interface BookRepository {
	void addBook(Book book);
    Book getBookById(int id);
    void removeBook(int bookId);
    void updateBook(Book book);
    List<Book> getAllBooks();
}
