package com.myexamportal.app.service;

import java.util.Set;

import com.myexamportal.app.model.exam.Question;
import com.myexamportal.app.model.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestion();

	public Question getQuestionById(Long id);
	
	public Question getQuestionByQuizIdAndQuestionId(Long quizId,Long queId);
	
	

	public void deleteQuestion(Long id);

	public Set<Question>getQuestionsOfQuiz(Quiz quiz);
}
