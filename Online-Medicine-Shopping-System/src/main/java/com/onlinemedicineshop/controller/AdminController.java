package com.onlinemedicineshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemedicineshop.entity.Admin;
import com.onlinemedicineshop.entity.Customer;
import com.onlinemedicineshop.exception.AdminNotFoundException;
import com.onlinemedicineshop.exception.CustomerNotFoundException;
import com.onlinemedicineshop.exception.NoCustomerPresentException;
import com.onlinemedicineshop.service.AdminService;
import com.onlinemedicineshop.service.CustomerService;
import com.onlinemedicineshop.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> list = adminService.getAllAdmins();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Admin> findAdminById(@PathVariable long id) {
		Optional<Admin> admin = adminService.findAdminById(id);
		if (admin.isEmpty()) {
			throw new AdminNotFoundException("No Admin found with the given id: " + id);
		}
		return ResponseEntity.ok(admin.get());
	}

//	@PostMapping("/save")
//	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
////		if(!adminService.getAllAdmins().isEmpty()) {
////			throw new AdminAlreadyRegisteredException("An Admin is already registered. Please login!");
////		}
//		Admin savedAdmin = adminService.saveAdmin(admin);
//		return ResponseEntity.ok(savedAdmin);
//	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		Optional<Admin> admin = adminService.findAdminById(id);
		if (admin.isEmpty()) {
			throw new AdminNotFoundException("No Admin found with the given id: " + id);
		}
		adminService.deleteAdminById(id);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		System.out.println("inside -----------------------------------");
		List<Customer> list = customerService.getAllCustomers();
		if (list.isEmpty()) {
			throw new NoCustomerPresentException("There are no customers present in the database!");
		}
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("customer/delete/{id}")
	public void deleteCustomerByid(@PathVariable long id) {
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("No customer found with id: " + id);
		}
		customerService.deleteCustomerById(id);
	}

//	// Authorization
//	@GetMapping("/get-logged-in")
//	public ResponseEntity<Admin> findAdminByUniqueId(@RequestHeader("Authorization") String authorizationHeader) {
//		String jwt = null;
//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//			jwt = authorizationHeader.substring(7);
//		} else {
//			throw new UnauthorizedAccessException("Access Denied!");
//		}
//		String email = jwtUtil.extractEmail(jwt);
//		Admin admin = adminService.getAdminByEmail(email)
//				.orElseThrow(() -> new UnauthorizedAccessException("Access Denied!"));
//		boolean isAdminValid = jwtUtil.validateToken(jwt, new UserDetailsImpl(admin, jwtUtil.extractRoles(jwt)));
//		if (!isAdminValid) {
//			throw new UnauthorizedAccessException("Access Denied!");
//		}
//		return ResponseEntity.ok(admin);
//	}

}
