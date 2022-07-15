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

import com.capg.entity.Customer;
import com.capg.entity.Order;
import com.capg.exception.CustomerNotFoundException;
import com.capg.exception.NoCustomerPresentException;
import com.capg.exception.OrderNotFoundException;
import com.capg.service.CustomerService;
import com.capg.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	@GetMapping("")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		if (list.isEmpty()) {
			throw new NoCustomerPresentException("There are no customers present in the database!");
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable long id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer found with id: " + id);
		}
		return ResponseEntity.ok(customer.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer found with id: " + id);
		}
		customerService.deleteCustomerById(id);
	}

	@GetMapping("/of-order/{orderId}")
	public ResponseEntity<Customer> getCustomerByOrderId(@PathVariable int orderId) {
		Optional<Order> order = orderService.findOrderById(orderId);
		if (order.isEmpty()) {
			throw new OrderNotFoundException("No Order found with the given id: " + orderId);
		}
		Customer customer = order.get().getCustomer();
		return ResponseEntity.ok(customer);
	}
}
