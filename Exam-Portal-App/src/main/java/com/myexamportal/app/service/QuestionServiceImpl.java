package com.myexamportal.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexamportal.app.model.exam.Question;
import com.myexamportal.app.model.exam.Quiz;
import com.myexamportal.app.repository.QuestionRepository;
import com.myexamportal.app.repository.QuizRepository;

@Service
public class QuestionServiceImpl  implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository; 
	
	@Autowired
	private QuizRepository quizRepository;
	
	
	@Autowired
	private QuizService quizService;
	
	
	
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);

	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepository.save(question);

	}

	@Override
	public Set<Question> getQuestion() {
		// TODO Auto-generated method stub
		return  new HashSet<Question>(questionRepository.findAll());
	
	}

	@Override
	public Question getQuestionById(Long id) {
		// TODO Auto-generated method stub
		return this.questionRepository.findById(id).get();
	}

	@Override
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		this.questionRepository.deleteById(id);
		
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public Question getQuestionByQuizIdAndQuestionId(Long quizId, Long queId) {
		
		Quiz quiz = quizService.getQuizById(quizId);
	
		Set<Question> questions = this.questionRepository.findByQuiz(quiz);
	
		for(Question one:questions) {
			
			if(one.getQuesId()==queId) {
				return one;
			}
		}
		return null;
		
		
	}

}
