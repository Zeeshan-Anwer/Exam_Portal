package com.myexamportal.app.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.myexamportal.app.service.UserDetailServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private UserDetailServiceImpl detailServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//	
//	   final String requestTokenHeader = request.getHeader("Authorization");
//	    System.out.println(requestTokenHeader);
//	    String username=null;
//	    String jwtToken=null;
//	    
//	 if(requestTokenHeader!=null&&requestTokenHeader.startsWith("Bearer ")) {
//		 // Successs
//	     	 jwtToken=requestTokenHeader.substring(7);
//	 	 try {
//			
//	 		username= this.jwtUtil.extractUsername(jwtToken);
//	 		 
//	 		 
//		} catch (ExpiredJwtException e) {
//			// TODO: handle exception
//		   e.printStackTrace();
//		   System.out.println("Jwt Token Has Expired");
//		 }
//		    catch (Exception e) {
//				// TODO: handle exception
//			  e.printStackTrace();
//			  System.out.println("Some Other Problem");
//		    }
//	 }
//	 else
//	 {
//		 System.out.println("Invalid Jwt Token Not Start With Bearer");
//	 }
//	
//	 //validated code 
//	
//	 if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
//		 
//		final UserDetails userDetails = this.detailServiceImpl.loadUserByUsername(username);
//	 
//		if(this.jwtUtil.validateToken(jwtToken, userDetails)) {
//			// if token valid true
//			
//			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//		
//			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//		
//		 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//		}
//	 
//		else {
//			System.out.println("Token is Not Valid");
//		}
//	  filterChain.doFilter(request, response);
//	 
//	 }
//	
//	
//	}
	
	
	
	
	   @Override
	    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
	                                    final FilterChain chain) throws ServletException, IOException {
	        // look for Bearer auth header
	        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
	        if (header == null || !header.startsWith("Bearer ")) {
	            chain.doFilter(request, response);
	            return;
	        }

	        final String token = header.substring(7);
	        final String username = jwtUtil.extractUsername(token);
	        if (username == null) {
	            // validation failed or token expired
	            chain.doFilter(request, response);
	            return;
	        }

	        // set user details on spring security context
	        final UserDetails userDetails = detailServiceImpl.loadUserByUsername(username);	//getting user
	        final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
	                userDetails, null, userDetails.getAuthorities());	//To Create Authentication User
	        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));	//Setting Details
	        SecurityContextHolder.getContext().setAuthentication(authentication);	//setting authentication to spring security

	        // continue with authenticated user
	        chain.doFilter(request, response);	//will go to security internal and if everything fine user will be authenticated
	    }
	
	
	
	

}
