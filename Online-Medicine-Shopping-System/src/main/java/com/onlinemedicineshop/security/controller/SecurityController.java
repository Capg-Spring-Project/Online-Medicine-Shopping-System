package com.onlinemedicineshop.security.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.onlinemedicineshop.security.model.AuthenticationRequest;
import com.onlinemedicineshop.security.model.AuthenticationResponse;
import com.onlinemedicineshop.security.service.UserDetailsServiceImpl;
import com.onlinemedicineshop.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SecurityController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;

	// TODO delete this method (its for testing only)
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		String jwtc = jwtUtil.generateTokenFromRequest(authenticationRequest);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtc, authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(jwtc);
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
