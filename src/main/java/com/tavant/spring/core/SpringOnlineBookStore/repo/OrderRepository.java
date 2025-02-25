package com.tavant.spring.core.SpringOnlineBookStore.repo;

import java.util.List;

import com.tavant.spring.core.SpringOnlineBookStore.entity.Order;

public interface OrderRepository {
    void saveOrder(Order order);
    Order findOrderById(int orderId);
    List<Order> findOrdersByUserId(int userId);
    void deleteOrder(int orderId);
    void updateOrder(Order order);
}

