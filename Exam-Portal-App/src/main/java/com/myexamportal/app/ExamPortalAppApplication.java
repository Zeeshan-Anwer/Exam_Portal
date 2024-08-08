package com.myexamportal.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myexamportal.app.model.Role;
import com.myexamportal.app.model.User;
import com.myexamportal.app.model.UserRole;
import com.myexamportal.app.service.UserService;

@SpringBootApplication
public class ExamPortalAppApplication implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalAppApplication.class, args);
	}

	@Autowired
	private UserService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//	
//		
//		User user= new User();
//		
//		user.setFirstName("Hemant");
//		user.setLastName("Saroj");
//		user.setEmail("HemantSaroj@gmail.com");
//		user.setEnabled(true);
//		user.setUsername("kevin");
//		user.setPhone("1212121212");
//		user.setProfile("profile.png");
//		user.setPassword(this.bCryptPasswordEncoder.encode("kevin"));
//		
//		Role giveRoleToUser= new Role();
//		giveRoleToUser.setId(10L);
//		giveRoleToUser.setRoleName("Admin");
//		
//		
//		Set<UserRole> userRoles= new HashSet<>();
//		
//		UserRole userRole= new UserRole();
//		 userRole.setRole(giveRoleToUser);
//		 userRole.setUser(user);
//		 userRoles.add(userRole);
//		
//		 service.createUser(user, userRoles);
//		
		
		
	}

}
