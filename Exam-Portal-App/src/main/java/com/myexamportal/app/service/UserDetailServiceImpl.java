package com.myexamportal.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myexamportal.app.model.User;
import com.myexamportal.app.repository.UserRepository;

@Service
public class UserDetailServiceImpl  implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		   User user = this.repository.findByUsername(username);
		
		   if(user==null)
		   {
			   
			   throw new RuntimeException("User not Found");		   
		   }
		   
		   
		return user;
	
	}

}
