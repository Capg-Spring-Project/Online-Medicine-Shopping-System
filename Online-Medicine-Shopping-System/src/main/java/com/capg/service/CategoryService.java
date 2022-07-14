package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategories();

	public Optional<Category> findCategoryById(long id);

	public Category saveCategory(Category category);

	public void deleteCategoryById(long id);
}
