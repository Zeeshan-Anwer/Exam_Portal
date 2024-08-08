package com.myexamportal.app.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexamportal.app.model.exam.Category;
import com.myexamportal.app.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {

		return categoryRepository.save(category);

	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub

		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub

		return this.categoryRepository.findById(id).get();

	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub

		this.categoryRepository.deleteById(id);

	}

}
