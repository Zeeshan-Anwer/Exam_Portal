package com.myexamportal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexamportal.app.model.exam.Category;
import com.myexamportal.app.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {

		Category category1 = this.categoryService.addCategory(category);

		return ResponseEntity.ok(category1);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId) {

		Category category = this.categoryService.getCategoryById(categoryId);

		return ResponseEntity.ok(category);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {

		return ResponseEntity.ok(this.categoryService.getCategories());
	}

	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category) {

		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {

		this.categoryService.deleteCategory(id);
		
	}
}
