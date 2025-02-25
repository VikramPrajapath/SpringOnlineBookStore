package com.tavant.spring.core.SpringOnlineBookStore.impl;

import java.util.ArrayList;
import java.util.List;
import com.tavant.spring.core.SpringOnlineBookStore.entity.Order;
import com.tavant.spring.core.SpringOnlineBookStore.repo.OrderRepository;

public class InMemoryOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void updateOrder(Order order) {
        int index = orders.indexOf(findOrderById(order.getOrderId()));
        if (index != -1) {
            orders.set(index, order);
        }
    }


	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		orders.add(order);
	}

	@Override
	public Order findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
	}

	@Override
	public List<Order> findOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
        return new ArrayList<>(orders);

	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
        orders.removeIf(order -> order.getOrderId() == orderId);

	}
}
