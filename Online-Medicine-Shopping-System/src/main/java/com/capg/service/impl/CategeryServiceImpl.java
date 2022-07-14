package com.capg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Category;
import com.capg.repository.CategoryRepository;
import com.capg.service.CategoryService;
@Service
public class CategeryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findCategoryById(long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(long id) {
		categoryRepository.deleteById(id);
	}
}
