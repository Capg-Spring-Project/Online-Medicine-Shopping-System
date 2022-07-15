package com.onlinemedicineshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshope.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}