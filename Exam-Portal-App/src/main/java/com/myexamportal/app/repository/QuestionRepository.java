package com.myexamportal.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myexamportal.app.model.exam.Question;
import com.myexamportal.app.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
