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
import com.capg.exception.CustomerNotFoundException;
import com.capg.exception.MedicineNotFoundException;
import com.capg.exception.NoOrderPresentException;
import com.capg.exception.OrderNotFoundException;
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
		if (list.isEmpty()) {
			throw new NoOrderPresentException("There are no orders present in the database!");
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable long id) {
		Optional<Order> order = orderService.findOrderById(id);
		if (order.isEmpty()) {
			throw new OrderNotFoundException("No order found with id: " + id);
		}
		return ResponseEntity.ok(order.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		Order savedOrder = orderService.saveOrder(order);
		return ResponseEntity.ok(savedOrder);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		Optional<Order> order = orderService.findOrderById(id);
		if (order.isEmpty()) {
			throw new OrderNotFoundException("No order found with id: " + id);
		}
		orderService.deleteOrderById(id);
	}

	@PostMapping("/{orderId}/assign-medicine/{medicineId}")
	private ResponseEntity<Order> assignMedicineToOrder(@PathVariable int orderId, @PathVariable int medicineId) {
		Optional<Order> orderOptional = orderService.findOrderById(orderId);
		if (orderOptional.isEmpty()) {
			throw new OrderNotFoundException("No order found with id: " + orderId);
		}
		Optional<Medicine> medicineOptional = medicineService.findMedicineById(medicineId);
		if (medicineOptional.isEmpty()) {
			throw new MedicineNotFoundException("No medicine found with id: " + medicineId);
		}
		Order order = orderOptional.get();
		Medicine medicine = medicineOptional.get();
		order.setMedicine(medicine);
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
	}

	@PostMapping("/{orderId}/assign-customer/{customerId}")
	private ResponseEntity<Order> assignCustomerToOrder(@PathVariable int orderId, @PathVariable int customerId) {
		Optional<Order> orderOptional = orderService.findOrderById(orderId);
		if (orderOptional.isEmpty()) {
			throw new OrderNotFoundException("No order found with id: " + orderId);
		}
		Optional<Customer> customerOptional = customerService.findCustomerById(customerId);
		if (customerOptional.isEmpty()) {
			throw new CustomerNotFoundException("No customer found with id: " + customerId);
		}
		Order order = orderOptional.get();
		Customer customer = customerOptional.get();
		order.setCustomer(customer);
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.OK);
	}

}
