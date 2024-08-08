package com.myexamportal.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexamportal.app.exception.UserFoundException;
import com.myexamportal.app.model.Role;
import com.myexamportal.app.model.User;
import com.myexamportal.app.model.UserDto;
import com.myexamportal.app.model.UserRole;
import com.myexamportal.app.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/create")
	private User createUser(@RequestBody User user) throws Exception {

		user.setProfile("default.png");

		// encoding password with bcrytPasswordEncoder

		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Set<UserRole> userRoles = new HashSet<>();

		UserRole userRole = new UserRole();

		Role role = new Role();

		role.setId(20L);
		role.setRoleName("Normal");

		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		return service.createUser(user, userRoles);

	}

	@PutMapping("/update")
	public UserDto updateUser(@RequestBody UserDto user) throws Exception {
		// Assuming you have a method to retrieve user roles by user ID from the
		// database

		Set<UserRole> userRoles = new HashSet<>();

		UserRole userRole = new UserRole();

		Role role = new Role();

		role.setId(20L);
		role.setRoleName("Normal");

		userRole.setRole(role);
		User users = service.getUserByUserName(user.getUsername());
		userRole.setUser(users);
		userRoles.add(userRole);

		// Call the update service method to update the user
		return service.updateUser(user, userRoles);
	}

	@GetMapping("/get/{username}")
	private User getUser(@PathVariable("username") String username) {

		User userByUserName = service.getUserByUserName(username);

		return userByUserName;

	}

	@GetMapping("/getAll")
	private List<User> getAllUser() {

		return service.getAllUsers();

	}

	@DeleteMapping("/delete/{Id}")
	private void deleteById(@PathVariable("Id") Long Id) {

		service.deleteById(Id);

	}

	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> UserNotFOundHAndler(UserFoundException ex) {

		return ResponseEntity.ok(ex.getMessage());
	}

}
