package com.myexamportal.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexamportal.app.exception.UserFoundException;
import com.myexamportal.app.exception.UserNotFoundException;
import com.myexamportal.app.model.User;
import com.myexamportal.app.model.UserDto;
import com.myexamportal.app.model.UserRole;
import com.myexamportal.app.repository.RoleRepository;
import com.myexamportal.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		
		
    User userFound = userRepository.findByUsername(user.getUsername());

    
    if(userFound!=null)
    {
    	throw new UserFoundException("User is Already Present in Our Database ");
    }
    else
    {
    	for(UserRole ur:userRoles) {
    		
    		roleRepository.save(ur.getRole());
    		
    	}
    
          user.getUserRoles().addAll(userRoles);
         
          userFound = userRepository.save(user);
    }
		
		
		return userFound;
	}
	public UserDto updateUser(UserDto user, Set<UserRole> userRoles) throws Exception {
	  
		UserDto userResponse= new UserDto();
		Optional<User> userToUpdateOpt = userRepository.findById(user.getId());

	    if (!userToUpdateOpt.isPresent()) {
	        throw new UserNotFoundException("User not found with ID: " + user.getId());
	    }

	    User userToUpdate = userToUpdateOpt.get();
	    
	    // Update the user's information
	    userToUpdate.setProfile("profile.png");
	    userToUpdate.setUsername(user.getUsername());
	    userToUpdate.setEmail(user.getEmail());
	    userToUpdate.setPhone(user.getPhone());
	    // ... add other fields you want to update

	    // Save the user with the updated information
	    User updatedUser = userRepository.save(userToUpdate);

	    // Update the user roles
	    Set<UserRole> updatedUserRoles = new HashSet<>();
	    for (UserRole ur : userRoles) {
	        ur.setUser(updatedUser);
	        updatedUserRoles.add(ur);
	    }
	    updatedUser.getUserRoles().clear();
	    updatedUser.getUserRoles().addAll(updatedUserRoles);
	    
	  

	     updatedUser=userRepository.save(updatedUser);
	    
	    
	    userResponse.setEmail(updatedUser.getEmail());
	    userResponse.setId(updatedUser.getId());
	    userResponse.setPhone(updatedUser.getPhone());
	    userResponse.setUsername(updatedUser.getUsername());
	    
	    return userResponse;
	}

	

	@Override
	public User getUserByUserName(String name) {
	
		User user = userRepository.findByUsername(name);
		
		return user;
	}

	@Override
	public void deleteById(Long Id) {
		
		userRepository.deleteById(Id);
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


}
