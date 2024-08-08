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
import com.myexamportal.app.model.exam.Quiz;
import com.myexamportal.app.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;

	
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {

		return ResponseEntity.ok(this.quizService.addQuiz(quiz));

	}

	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {

		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));

	}

	@GetMapping("/")
	public ResponseEntity<?> getAllQuiz() {

		return ResponseEntity.ok(this.quizService.getQuiz());

	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getQuizById(@PathVariable("id") Long id) {

		return ResponseEntity.ok(this.quizService.getQuizById(id));

	}
	
	@DeleteMapping("/{id}")
	public void deleteQuizById(@PathVariable("id") Long id) {

		this.quizService.deleteQuiz(id);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> publishQuiz(@PathVariable("id") Long id) {
		Quiz quiz = quizService.publishedQuizById(id);
		if (quiz != null) {
			return ResponseEntity.ok(quiz);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getQuizByCategoryId(@PathVariable("id") Long id) {

		Category category= new  Category();
		category.setcId(id);
		
		
		return ResponseEntity.ok(this.quizService.getQuizByCategory(category));

	}

}
