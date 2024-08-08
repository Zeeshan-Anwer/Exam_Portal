package com.myexamportal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myexamportal.app.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
