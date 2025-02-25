package com.tavant.spring.core.SpringOnlineBookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.core.SpringOnlineBookStore.entity.Order;
import com.tavant.spring.core.SpringOnlineBookStore.repo.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order) {
        orderRepository.saveOrder(order);
    }

    public Order viewOrder(int orderId) {
        return orderRepository.findOrderById(orderId);
    }

    public List<Order> viewOrderHistory(int userId) {
        return orderRepository.findOrdersByUserId(userId);
    }

    public void cancelOrder(int orderId) {
        orderRepository.deleteOrder(orderId);
    }
}

