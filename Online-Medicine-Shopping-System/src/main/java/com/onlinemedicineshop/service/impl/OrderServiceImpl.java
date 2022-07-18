package com.onlinemedicineshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemedicineshop.entity.Order;
import com.onlinemedicineshop.repository.OrderRepository;
import com.onlinemedicineshop.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findOrderById(long id) {
		return orderRepository.findById(id);
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(long id) {
		orderRepository.deleteById(id);
	}
}
