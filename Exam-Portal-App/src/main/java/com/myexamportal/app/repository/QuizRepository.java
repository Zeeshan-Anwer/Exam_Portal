package com.myexamportal.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.myexamportal.app.model.exam.Category;
import com.myexamportal.app.model.exam.Quiz;

import jakarta.transaction.Transactional;

public interface QuizRepository  extends JpaRepository<Quiz, Long> {

	
	@Modifying
    @Transactional
	@Query(value = "DELETE FROM quiz WHERE q_id = ?", nativeQuery = true)
	public void deleteQuiz(Long qid);

	public List<Quiz> findBycategory(Category category);
}
