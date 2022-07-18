package com.onlinemedicineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}