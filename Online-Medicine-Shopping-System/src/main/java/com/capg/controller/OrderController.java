package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.entity.Medicine;
import com.capg.entity.Order;
import com.capg.service.CustomerService;
import com.capg.service.MedicineService;
import com.capg.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> list = orderService.getAllOrders();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable long id) {
		Optional<Order> order = orderService.findOrderById(id);
		return ResponseEntity.ok(order.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		Order savedOrder = orderService.saveOrder(order);
		return ResponseEntity.ok(savedOrder);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		orderService.deleteOrderById(id);
	}

	@PostMapping("/{orderId}/assign-medicine/{medicineId}")
	private ResponseEntity<Order> assignMedicineToOrder(@PathVariable int orderId, @PathVariable int medicineId) {
		Order order = orderService.findOrderById(orderId).get();
		Medicine medicine = medicineService.findMedicineById(medicineId).get();
		order.setMedicine(medicine);
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
	}

	@PostMapping("/{orderId}/assign-customer/{customerId}")
	private ResponseEntity<Order> assignCustomerToOrder(@PathVariable int orderId, @PathVariable int customerId) {
		Order order = orderService.findOrderById(orderId).get();
		Customer customer = customerService.findCustomerById(customerId).get();
		order.setCustomer(customer);
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
	}

	@GetMapping("/of-medicine/{medicineId}")
	public ResponseEntity<List<Order>> getOrdersByMedicineId(@PathVariable int medicineId) {
		List<Order> medicines = medicineService.findMedicineById(medicineId).get().getOrders();
		return ResponseEntity.ok(medicines);
	}

	@GetMapping("/of-customer/{customerId}")
	public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable int customerId) {
		List<Order> customers = customerService.findCustomerById(customerId).get().getOrders();
		return ResponseEntity.ok(customers);
	}
}
