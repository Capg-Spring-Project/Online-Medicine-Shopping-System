package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.entity.Order;

public interface OrderService {
	public List<Order> getAllOrders();

	public Optional<Order> findOrderById(long id);

	public Order saveOrder(Order order);

	public void deleteOrderById(long id);
}
