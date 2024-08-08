package com.myexamportal.app.service;

import java.util.Set;

import com.myexamportal.app.model.exam.Category;

public interface CategoryService {

	public Category addCategory(Category category);

	public Category updateCategory(Category category);

	public Set<Category> getCategories();

	public Category getCategoryById(Long id);

	public void deleteCategory(Long id);
}
