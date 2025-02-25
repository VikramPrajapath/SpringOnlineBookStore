package com.tavant.spring.core.SpringOnlineBookStore.repo;

import com.tavant.spring.core.SpringOnlineBookStore.entity.Cart;
import java.util.List;

public interface CartRepository {
    void addCart(Cart cart);
    void removeCart(int userId);
    void updateCart(Cart cart);
    Cart getCartByUserId(int userId);
    List<Cart> getAllCarts();
}

