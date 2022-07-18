package com.onlinemedicineshop.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlinemedicineshop.security.model.User;
import com.onlinemedicineshop.security.model.UserDetailsImpl;
import com.onlinemedicineshop.service.AdminService;
import com.onlinemedicineshop.service.CustomerService;
import com.onlinemedicineshop.util.JwtUtil;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public UserDetails loadUserByUsername(String jwt) throws UsernameNotFoundException {
		String email = jwtUtil.extractEmail(jwt);
		List<SimpleGrantedAuthority> roles = jwtUtil.extractRoles(jwt); 
		boolean isAdmin = roles.stream().map(p -> p.getAuthority()).anyMatch(p -> p.equals("ROLE_ADMIN"));
		boolean isUser = roles.stream().map(p -> p.getAuthority()).anyMatch(p -> p.equals("ROLE_USER"));
		Optional<User> user = null;
		if(isAdmin) {
			user = adminService.getAdminAsUserByEmail(email);		
		}
		if(isUser) {
			user = customerService.getCustomerAsUserByEmail(email);
		}
		user.orElseThrow(() -> new RuntimeException("user not found"));
		return new UserDetailsImpl(user.get(), roles);
	}

}
