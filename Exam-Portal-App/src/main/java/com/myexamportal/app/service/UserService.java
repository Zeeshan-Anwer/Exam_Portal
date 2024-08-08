package com.myexamportal.app.service;

import java.util.List;
import java.util.Set;

import com.myexamportal.app.model.User;
import com.myexamportal.app.model.UserDto;
import com.myexamportal.app.model.UserRole;

public interface UserService {

	
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	public UserDto updateUser(UserDto user, Set<UserRole> userRoles) throws Exception;
	
	public User getUserByUserName(String name);
	
	public List<User> getAllUsers();
	
	public void deleteById(Long Id);
	
	
}
