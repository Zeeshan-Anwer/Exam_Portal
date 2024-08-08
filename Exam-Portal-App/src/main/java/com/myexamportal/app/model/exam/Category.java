package com.myexamportal.app.model.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	
	private String title;
	
	private String description;

	
@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
@JsonIgnore	
private Set<Quiz> quizzes= new LinkedHashSet<>();
	
	
	public Category(String title, String description) {
		this.title = title;
		this.description = description;
	}

	
	
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Long getcId() {
		return cId;
	}



	public void setcId(Long cId) {
		this.cId = cId;
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
	
	
	
	
	
}
