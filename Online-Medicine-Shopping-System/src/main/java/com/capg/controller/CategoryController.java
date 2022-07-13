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

import com.capg.entity.Category;
import com.capg.service.MainService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private MainService mainService;

	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> list = mainService.getAllCategories();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable long id) {
		Optional<Category> category = mainService.findCategoryById(id);
		return ResponseEntity.ok(category.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		Category savedCategory = mainService.saveCategory(category);
		return ResponseEntity.ok(savedCategory);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		mainService.deleteCategoryById(id);
	}
}
