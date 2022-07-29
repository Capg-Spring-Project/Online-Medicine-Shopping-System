package com.onlinemedicineshop.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemedicineshop.entity.Customer;
import com.onlinemedicineshop.entity.Medicine;
import com.onlinemedicineshop.entity.Order;
import com.onlinemedicineshop.exception.CustomerNotFoundException;
import com.onlinemedicineshop.exception.InvalidIdException;
import com.onlinemedicineshop.exception.OrderNotFoundException;
import com.onlinemedicineshop.service.CustomerService;
import com.onlinemedicineshop.service.MedicineService;
import com.onlinemedicineshop.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MedicineService medicineService;

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable long id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer found with id: " + id);
		}
		return ResponseEntity.ok(customer.get());
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

	@PostMapping("/{customerId}/add-medicine/{medicineId}")
	public ResponseEntity<Customer> addMedicineToCustomer(@PathVariable int customerId, @PathVariable int medicineId) {
		if (customerId < 0 || medicineId < 0) {
			throw new InvalidIdException("Either one of the ids is invalid please enter correct");
		} else {
			Customer customer = customerService.findCustomerById(customerId).get();
			Medicine medicine = medicineService.findMedicineById(medicineId).get();
			customer.getCartMedicines().add(medicine);
			return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.ACCEPTED);
		}
	}
	
	@PostMapping("/{customerId}/remove-medicine/{medicineId}")
	public ResponseEntity<Customer> removeMedicineFromCustomer(@PathVariable int customerId, @PathVariable int medicineId) {
		if (customerId < 0 || medicineId < 0) {
			throw new InvalidIdException("Either one of the ids is invalid please enter correct");
		} else {
			Customer customer = customerService.findCustomerById(customerId).get();
			List<Medicine> updatedMedicines = customer.getCartMedicines().stream()
			.filter(med -> med.getId() != medicineId)
			.collect(Collectors.toList());
			customer.setCartMedicines(updatedMedicines);
			return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.ACCEPTED);
		}
	}

}
