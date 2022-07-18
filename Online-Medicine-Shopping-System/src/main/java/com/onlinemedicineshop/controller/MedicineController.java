package com.onlinemedicineshop.controller;

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

import com.onlinemedicineshop.entity.Category;
import com.onlinemedicineshop.entity.Medicine;
import com.onlinemedicineshop.entity.Order;
import com.onlinemedicineshop.exception.CategoryNotFoundException;
import com.onlinemedicineshop.exception.MedicineNotFoundException;
import com.onlinemedicineshop.exception.NoMedicinePresentException;
import com.onlinemedicineshop.exception.OrderNotFoundException;
import com.onlinemedicineshop.service.CategoryService;
import com.onlinemedicineshop.service.MedicineService;
import com.onlinemedicineshop.service.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/medicine")
public class MedicineController {
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public ResponseEntity<List<Medicine>> getAllMedicines() {
		List<Medicine> list = medicineService.getAllMedicines();
		if (list.isEmpty()) {
			throw new NoMedicinePresentException("There are no medicines present in the database!");
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicine> findMedicineById(@PathVariable long id) {
		Optional<Medicine> medicine = medicineService.findMedicineById(id);
		if (medicine.isEmpty()) {
			throw new MedicineNotFoundException("No medicine found with id: " + id);
		}
		return ResponseEntity.ok(medicine.get());
	}

	@PostMapping("/save")
	public ResponseEntity<Medicine> saveMedicine(@RequestBody Medicine medicine) {
		Medicine savedMedicine = medicineService.saveMedicine(medicine);
		return ResponseEntity.ok(savedMedicine);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteByid(@PathVariable long id) {
		Optional<Medicine> medicine = medicineService.findMedicineById(id);
		if (medicine.isEmpty()) {
			throw new MedicineNotFoundException("No medicine found with id: " + id);
		}
		medicineService.deleteMedicineById(id);
	}

	@PostMapping("/{medicineId}/assign-category/{categoryId}")
	private ResponseEntity<Medicine> assignCategoryToMedicine(@PathVariable int medicineId,
			@PathVariable int categoryId) {
		Optional<Medicine> medicineOptional = medicineService.findMedicineById(medicineId);
		if (medicineOptional.isEmpty()) {
			throw new MedicineNotFoundException("No medicine found with id: " + medicineId);
		}
		Optional<Category> categoryOptional = categoryService.findCategoryById(categoryId);
		if (categoryOptional.isEmpty()) {
			throw new CategoryNotFoundException("No category found with id: " + categoryId);
		}
		Medicine medicine = medicineOptional.get();
		Category category = categoryOptional.get();
		medicine.setCategory(category);
		return new ResponseEntity<Medicine>(medicineService.saveMedicine(medicine), HttpStatus.OK);
	}

	@GetMapping("/of-order/{orderId}")
	public ResponseEntity<Medicine> getMedicineByOrderId(@PathVariable int orderId) {
		Optional<Order> order = orderService.findOrderById(orderId);
		if (order.isEmpty()) {
			throw new OrderNotFoundException("No Order found with the given id: " + orderId);
		}
		Medicine medicine = order.get().getMedicine();
		return ResponseEntity.ok(medicine);
	}
}
