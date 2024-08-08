package com.myexamportal.app.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexamportal.app.model.exam.Category;
import com.myexamportal.app.model.exam.Quiz;
import com.myexamportal.app.repository.QuizRepository;

@Service
public class QuizServiceImpl  implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
	return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz() {
		// TODO Auto-generated method stub
	 return new LinkedHashSet<>(this.quizRepository.findAll())  ;
		
	
	}

	@Override
	public Quiz getQuizById(Long id) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(id).get();
	}

	@Override
	public void deleteQuiz(Long id) {
		// TODO Auto-generated method stub
		
		this.quizRepository.deleteById(id);;
	}

	@Override
	public List<Quiz> getQuizByCategory(Category category) {
		// TODO Auto-generated method stub
		
		return  this.quizRepository.findBycategory(category);
		
		 
	}

	@Override
	public Quiz publishedQuizById(Long quizId) {
		// TODO Auto-generated method stub
	
		Quiz quiz = this.quizRepository.findById(quizId).get();
	
		
		quiz.setActive(true);
		
		quiz= this.quizRepository.save(quiz);
		
		return quiz;
	}

}
