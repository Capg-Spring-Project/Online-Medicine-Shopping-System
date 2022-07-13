package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}