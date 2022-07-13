package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Order;
import com.capg.service.MainService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private MainService mainService;

	@GetMapping("")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> list = mainService.getAllOrders();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable long id) {
		Optional<Order> order = mainService.findOrderById(id);
		return ResponseEntity.ok(order.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		Order savedOrder = mainService.saveOrder(order);
		return ResponseEntity.ok(savedOrder);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		mainService.deleteOrderById(id);
	}
}
