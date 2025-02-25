package com.tavant.spring.core.SpringOnlineBookStore.entity;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private LocalDate orderDate;
    private List<Book> books;

    public Order(int orderId, int userId, LocalDate orderDate, List<Book> books) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.books = books;
    }

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", books=" + books
				+ "]";
	}

    
}

