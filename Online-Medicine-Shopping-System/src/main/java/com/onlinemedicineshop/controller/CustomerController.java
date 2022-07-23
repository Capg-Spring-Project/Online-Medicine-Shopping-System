package com.onlinemedicineshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemedicineshop.entity.Customer;
import com.onlinemedicineshop.entity.Order;
import com.onlinemedicineshop.exception.CustomerNotFoundException;
import com.onlinemedicineshop.exception.OrderNotFoundException;
import com.onlinemedicineshop.service.CustomerService;
import com.onlinemedicineshop.service.OrderService;
import com.onlinemedicineshop.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private JwtUtil jwtUtil;

	//TODO Remove this
//	@GetMapping("")
//	public ResponseEntity<List<Customer>> getAllCustomers() {
//		List<Customer> list = customerService.getAllCustomers();
//		if (list.isEmpty()) {
//			throw new NoCustomerPresentException("There are no customers present in the database!");
//		}
//		return ResponseEntity.ok(list);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable long id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer found with id: " + id);
		}
		return ResponseEntity.ok(customer.get());
	}
	

//	@PostMapping("/save")
//	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
//		Customer savedCustomer = customerService.saveCustomer(customer);
//		return ResponseEntity.ok(savedCustomer);
//	}


	@GetMapping("/of-order/{orderId}")
	public ResponseEntity<Customer> getCustomerByOrderId(@PathVariable int orderId) {
		Optional<Order> order = orderService.findOrderById(orderId);
		if (order.isEmpty()) {
			throw new OrderNotFoundException("No Order found with the given id: " + orderId);
		}
		Customer customer = order.get().getCustomer();
		return ResponseEntity.ok(customer);
	}
	
	
//	//Authorization
//	@GetMapping("/get-logged-in")
//	public ResponseEntity<Customer> findCustomerByUniqueId(@RequestHeader("Authorization") String authorizationHeader) {
//		String jwt = null;
//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7);
//        } else {
//        	throw new UnauthorizedAccessException("Access Denied!");
//        }
//		String email = jwtUtil.extractEmail(jwt);
//		Customer customer = customerService.getCustomerByEmail(email)
//				.orElseThrow(() -> new UnauthorizedAccessException("Access Denied!"));
//		boolean isCustomerValid = jwtUtil.validateToken(jwt, new UserDetailsImpl(customer, jwtUtil.extractRoles(jwt)));
//		if(!isCustomerValid) {
//			throw new UnauthorizedAccessException("Access Denied!");
//		}
//		return ResponseEntity.ok(customer);
//	}	
}
