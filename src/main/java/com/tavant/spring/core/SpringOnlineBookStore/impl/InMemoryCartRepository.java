package com.tavant.spring.core.SpringOnlineBookStore.impl;

import java.util.ArrayList;
import java.util.List;
import com.tavant.spring.core.SpringOnlineBookStore.entity.Cart;
import com.tavant.spring.core.SpringOnlineBookStore.repo.CartRepository;

public class InMemoryCartRepository implements CartRepository {
    private List<Cart> carts = new ArrayList<>();

    @Override
    public void addCart(Cart cart) {
        carts.add(cart);
    }

    @Override
    public void removeCart(int userId) {
        carts.removeIf(cart -> cart.getUserId() == userId);
    }

    @Override
    public void updateCart(Cart cart) {
        int index = carts.indexOf(getCartByUserId(cart.getUserId()));
        if (index != -1) {
            carts.set(index, cart);
        }
    }

    @Override
    public Cart getCartByUserId(int userId) {
        return carts.stream()
                    .filter(cart -> cart.getUserId() == userId)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return new ArrayList<>(carts);
    }
}

