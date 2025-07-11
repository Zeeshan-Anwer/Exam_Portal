package com.myexamportal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myexamportal.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	

}
