package com.tavant.spring.core.SpringOnlineBookStore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tavant.spring.core.SpringOnlineBookStore.entity.Book;
import com.tavant.spring.core.SpringOnlineBookStore.entity.Cart;

@Service
public class CartService {
    private Map<Integer, Cart> cartStore = new HashMap<>();

    public Cart getCartByUserId(int userId) {
        return cartStore.computeIfAbsent(userId, Cart::new);
    }

    public void addBookToCart(int userId, Book book) {
        Cart cart = getCartByUserId(userId);
        cart.addBook(book);
    }

    public void removeBookFromCart(int userId, Book book) {
        Cart cart = getCartByUserId(userId);
        cart.removeBook(book);
    }

    public List<Book> viewCart(int userId) {
        return getCartByUserId(userId).viewBooks();
    }
}


