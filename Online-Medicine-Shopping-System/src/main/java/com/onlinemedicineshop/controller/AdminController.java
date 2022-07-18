package com.onlinemedicineshop.controller;

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

import com.onlinemedicineshop.entity.Admin;
import com.onlinemedicineshop.exception.AdminAlreadyRegisteredException;
import com.onlinemedicineshop.exception.AdminNotFoundException;
import com.onlinemedicineshop.service.AdminService;


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
//		if(!adminService.getAllAdmins().isEmpty()) {
//			throw new AdminAlreadyRegisteredException("An Admin is already registered. Please login!");
//		}
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
	
}
