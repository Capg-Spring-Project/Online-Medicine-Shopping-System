package com.onlinemedicineshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinemedicineshop.entity.Category;
import com.onlinemedicineshop.entity.Medicine;
import com.onlinemedicineshop.exception.MedicineNotFoundException;
import com.onlinemedicineshop.exception.NoMedicinePresentException;
import com.onlinemedicineshop.service.MedicineService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/commons")
public class CommonController {
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("medicines")
	public ResponseEntity<List<Medicine>> getAllMedicines() {
		List<Medicine> list = medicineService.getAllMedicines();
		if (list.isEmpty()) {
			throw new NoMedicinePresentException("There are no medicines present in the database!");
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("category-of-medicine/{medicineId}")
	public ResponseEntity<Category> getCategoryByMedicineId(@PathVariable int medicineId) {
		Optional<Medicine> medicine = medicineService.findMedicineById(medicineId);
		if(medicine.isEmpty()) {
			throw new MedicineNotFoundException("No Medicine found with the given id: " + medicineId);
		}
		Category category = medicine.get().getCategory();
		return ResponseEntity.ok(category);
	}
}


