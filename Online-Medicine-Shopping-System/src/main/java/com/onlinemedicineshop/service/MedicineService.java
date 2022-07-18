package com.onlinemedicineshop.service;

import java.util.List;
import java.util.Optional;

import com.onlinemedicineshop.entity.Medicine;

public interface MedicineService {
	public List<Medicine> getAllMedicines();

	public Optional<Medicine> findMedicineById(long id);

	public Medicine saveMedicine(Medicine medicine);

	public void deleteMedicineById(long id);
}
