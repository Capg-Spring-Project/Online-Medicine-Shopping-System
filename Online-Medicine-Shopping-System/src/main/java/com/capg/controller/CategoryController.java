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
import com.capg.service.CategoryService;
import com.capg.service.MedicineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MedicineService medicineService;

	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> list = categoryService.getAllCategories();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable long id) {
		Optional<Category> category = categoryService.findCategoryById(id);
		return ResponseEntity.ok(category.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.saveCategory(category);
		return ResponseEntity.ok(savedCategory);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		categoryService.deleteCategoryById(id);
	}

	@GetMapping("/of-medicine/{medicineId}")
	public ResponseEntity<Category> getCategoryByMedicineId(@PathVariable int medicineId) {
		Category category = medicineService.findMedicineById(medicineId).get().getCategory();
		return ResponseEntity.ok(category);
	}
}
