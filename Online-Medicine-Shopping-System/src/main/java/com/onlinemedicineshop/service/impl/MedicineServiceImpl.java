package com.onlinemedicineshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemedicineshop.entity.Medicine;
import com.onlinemedicineshop.repository.MedicineRepository;
import com.onlinemedicineshop.service.MedicineService;
@Service
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	MedicineRepository medicineRepository;
	
	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	@Override
	public Optional<Medicine> findMedicineById(long id) {
		return medicineRepository.findById(id);
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public void deleteMedicineById(long id) {
		medicineRepository.deleteById(id);
	}

}
