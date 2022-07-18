package com.onlinemedicineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshop.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}