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

import com.capg.entity.Admin;
import com.capg.service.MainService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private MainService mainService;

	@GetMapping("")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> list = mainService.getAllAdmins();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Admin> findAdminById(@PathVariable long id) {
		Optional<Admin> admin = mainService.findAdminById(id);
		return ResponseEntity.ok(admin.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		Admin savedAdmin = mainService.saveAdmin(admin);
		return ResponseEntity.ok(savedAdmin);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		mainService.deleteAdminById(id);
	}
}
