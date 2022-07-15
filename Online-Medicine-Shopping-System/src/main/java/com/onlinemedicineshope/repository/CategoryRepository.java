package com.onlinemedicineshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshope.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}