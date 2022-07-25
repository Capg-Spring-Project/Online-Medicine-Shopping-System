package com.onlinemedicineshop.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemedicineshop.entity.Admin;
import com.onlinemedicineshop.entity.Customer;
import com.onlinemedicineshop.exception.InvalidCredentialsException;
import com.onlinemedicineshop.exception.UnauthorizedAccessException;
import com.onlinemedicineshop.security.model.AuthenticationRequest;
import com.onlinemedicineshop.security.model.AuthenticationResponse;
import com.onlinemedicineshop.security.model.UserDetailsImpl;
import com.onlinemedicineshop.security.service.UserDetailsServiceImpl;
import com.onlinemedicineshop.service.AdminService;
import com.onlinemedicineshop.service.CustomerService;
import com.onlinemedicineshop.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/authentication")
public class SecurityController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AdminService adminService;

	// TODO delete this method (its for testing only)
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/register-customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		System.out.println("------------ customer = " + customer.getId());
		Customer savedCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.ok(savedCustomer);
	}
	
	@PostMapping("/register-admin")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
//		if(!adminService.getAllAdmins().isEmpty()) {
//			throw new AdminAlreadyRegisteredException("An Admin is already registered. Please login!");
//		}
		Admin savedAdmin = adminService.saveAdmin(admin);
		return ResponseEntity.ok(savedAdmin);
	}

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		String jwtc = jwtUtil.generateTokenFromRequest(authenticationRequest);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtc, authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new InvalidCredentialsException("Entered Credentials are Incorrect!");
		}
		final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(jwtc);
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@GetMapping("/admin/get-logged-in")
	public ResponseEntity<Admin> findAdminByUniqueId(@RequestHeader("Authorization") String authorizationHeader) {
		String jwt = null;
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
		} else {
			throw new UnauthorizedAccessException("Email not registered!");
		}
		String email = jwtUtil.extractEmail(jwt);
		Admin admin = adminService.getAdminByEmail(email)
				.orElseThrow(() -> new UnauthorizedAccessException("Email not registered!"));
		boolean isAdminValid = jwtUtil.validateToken(jwt, new UserDetailsImpl(admin, jwtUtil.extractRoles(jwt)));
		if (!isAdminValid) {
			throw new UnauthorizedAccessException("Email not registered!");
		}
		return ResponseEntity.ok(admin);
	}
	
	@GetMapping("customer/get-logged-in")
	public ResponseEntity<Customer> findCustomerByUniqueId(@RequestHeader("Authorization") String authorizationHeader) {
		String jwt = null;
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        } else {
        	throw new UnauthorizedAccessException("Email not registered!");
        }
		String email = jwtUtil.extractEmail(jwt);
		Customer customer = customerService.getCustomerByEmail(email)
				.orElseThrow(() -> new UnauthorizedAccessException("Email not registered!"));
		boolean isCustomerValid = jwtUtil.validateToken(jwt, new UserDetailsImpl(customer, jwtUtil.extractRoles(jwt)));
		if(!isCustomerValid) {
			throw new UnauthorizedAccessException("Email not registered!");
		}
		return ResponseEntity.ok(customer);
	}
}
