package com.myexamportal.app.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import com.myexamportal.app.model.exam.Question;
import com.myexamportal.app.model.exam.Quiz;
import com.myexamportal.app.service.QuestionService;
import com.myexamportal.app.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question) {

		Question question1 = this.questionService.addQuestion(question);

		return ResponseEntity.ok(question1);
	}

	@GetMapping("/{questionId}")
	public ResponseEntity<?> getQuestion(@PathVariable("questionId") Long questionId) {

		Question question = this.questionService.getQuestionById(questionId);

		return ResponseEntity.ok(question);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllQuestion() {

		return ResponseEntity.ok(this.questionService.getQuestion());
	}

	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) {

		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}

	@GetMapping("/quiz/all/{id}")
	public ResponseEntity<?> getQuestionOfAdminQuiz(@PathVariable("id") Long id) {

		Quiz quiz = this.quizService.getQuizById(id);

		Set<Question> questions = quiz.getQuestions();
	

		return ResponseEntity.ok(questions);
	}

	
	
	

	@GetMapping("/quiz/{id}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("id") Long id) {

		Quiz quiz = this.quizService.getQuizById(id);

		 Set<Question> questions = quiz.getQuestions();
		 List list = new ArrayList(questions);
		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {

			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		java.util.Collections.shuffle(list);

		return ResponseEntity.ok(list);
	}

	
	
	
	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable("id") Long id) {

		this.questionService.deleteQuestion(id);

	}

	
	    
}
