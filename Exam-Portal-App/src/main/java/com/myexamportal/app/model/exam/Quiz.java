package com.myexamportal.app.model.exam;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Quiz {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
	
	private String title;
	
	private String description;
	
	private String maxMarks;
	
	
	private String numberOfQuestions;
	
	private boolean active=false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Question> questions= new HashSet<>();

	
	
	
	
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(String numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
