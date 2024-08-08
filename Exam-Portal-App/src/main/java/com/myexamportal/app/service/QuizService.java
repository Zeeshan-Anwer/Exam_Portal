package com.myexamportal.app.service;

import java.util.List;
import java.util.Set;

import com.myexamportal.app.model.exam.Category;
import com.myexamportal.app.model.exam.Quiz;

public interface QuizService {

	
	public Quiz addQuiz(Quiz category);

	public Quiz updateQuiz(Quiz quiz);

	public Quiz publishedQuizById(Long quizId);

	
	public Set<Quiz> getQuiz();
	

	public Quiz getQuizById(Long id);

	public void deleteQuiz(Long id);

	public List<Quiz> getQuizByCategory(Category category);
	
}	
