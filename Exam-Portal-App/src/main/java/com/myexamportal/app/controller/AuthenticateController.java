package com.myexamportal.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myexamportal.app.config.JwtUtil;
import com.myexamportal.app.model.JwtRequest;
import com.myexamportal.app.model.JwtResponse;
import com.myexamportal.app.model.User;
import com.myexamportal.app.service.UserDetailServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {

			autheticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (UsernameNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("user not found from controller");
		}

		// authenticate

		UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void autheticate(String username, String password) throws Exception {

//		
//		
//		Authentication authentication = 
//		        authenticationManager.authenticate(
//		            new UsernamePasswordAuthenticationToken(username, password)
//		        );
//
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		// userDetails.getUsername()
//		// userDetails.getPassword()
//		// userDetails.getAuthorities()
//		

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			// TODO: handle exception
			throw new Exception("User Disabled " + e.getMessage());
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Bad Credentials " + e.getMessage());
		}

	}

	
	
	
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		
		
		return  (User) this.userDetailServiceImpl.loadUserByUsername(principal.getName());
		
		
		
	}
	
	
	
	
}
