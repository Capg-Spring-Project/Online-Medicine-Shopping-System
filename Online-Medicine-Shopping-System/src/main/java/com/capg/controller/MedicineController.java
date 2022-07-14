package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.capg.entity.Medicine;
import com.capg.service.CategoryService;
import com.capg.service.MedicineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/medicine")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public ResponseEntity<List<Medicine>> getAllMedicines() {
		List<Medicine> list = medicineService.getAllMedicines();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicine> findMedicineById(@PathVariable long id) {
		Optional<Medicine> medicine = medicineService.findMedicineById(id);
		return ResponseEntity.ok(medicine.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine) {
		Medicine savedMedicine = medicineService.saveMedicine(medicine);
		return ResponseEntity.ok(savedMedicine);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		medicineService.deleteMedicineById(id);
	}

	@PostMapping("/{medicineId}/assign-category/{categoryId}")
	private ResponseEntity<Medicine> assignCategoryToMedicine(@PathVariable int medicineId,
			@PathVariable int categoryId) {
		Medicine medicine = medicineService.findMedicineById(medicineId).get();
		Category category = categoryService.findCategoryById(categoryId).get();
		medicine.setCategory(category);
		return new ResponseEntity<Medicine>(medicineService.saveMedicine(medicine), HttpStatus.OK);
	}
}
