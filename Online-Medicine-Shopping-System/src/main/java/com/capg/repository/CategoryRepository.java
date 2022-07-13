package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}