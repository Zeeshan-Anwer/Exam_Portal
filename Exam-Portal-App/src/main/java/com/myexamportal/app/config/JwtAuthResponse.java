package com.myexamportal.app.config;


public class JwtAuthResponse {

	
	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	private String Token;

}
