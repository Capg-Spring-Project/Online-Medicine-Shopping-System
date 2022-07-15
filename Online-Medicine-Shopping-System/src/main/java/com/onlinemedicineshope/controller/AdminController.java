package com.onlinemedicineshope.controller;

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

import com.onlinemedicineshope.entity.Admin;
import com.onlinemedicineshope.exception.AdminAlreadyRegisteredException;
import com.onlinemedicineshope.exception.AdminNotFoundException;
import com.onlinemedicineshope.exception.InvalidCredentialsException;
import com.onlinemedicineshope.service.AdminService;

// test edit
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> list = adminService.getAllAdmins();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Admin> findAdminById(@PathVariable long id) {
		Optional<Admin> admin = adminService.findAdminById(id);
		if(admin.isEmpty()) {
			throw new AdminNotFoundException("No Admin found with the given id: " + id);
		}
		return ResponseEntity.ok(admin.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		if(!adminService.getAllAdmins().isEmpty()) {
			throw new AdminAlreadyRegisteredException("An Admin is already registered. Please login!");
		}
		Admin savedAdmin = adminService.saveAdmin(admin);
		return ResponseEntity.ok(savedAdmin);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		Optional<Admin> admin = adminService.findAdminById(id);
		if(admin.isEmpty()) {
			throw new AdminNotFoundException("No Admin found with the given id: " + id);
		}
		adminService.deleteAdminById(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Admin> login(@RequestBody Admin admin) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		List<Admin> adminList = adminService.getAllAdmins();
		Optional<Admin> matchedAdminOptional = adminList.stream().filter(p -> p.getEmail().equals(email)).findFirst();
		if(matchedAdminOptional.isEmpty()) {
			throw new InvalidCredentialsException("Entered email did not match any data");
		}
		
		Admin matchedAdmin = matchedAdminOptional.get();
		if(matchedAdmin.getPassword().equals(password)) {
			return ResponseEntity.ok(matchedAdmin);
		} else {
			throw new InvalidCredentialsException("Entered password is incorrect!");
		}
	}
}
