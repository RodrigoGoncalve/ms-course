package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feingclients.UserFeingClient;

@Service
public class UserService implements UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeingClient userFeingClient;
	
	public User findByEmail(@RequestParam String email){
		User user = userFeingClient.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: "+ email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: "+ email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeingClient.findByEmail(username).getBody();
		if(user == null) {
			logger.error("Email not found: "+ username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("Email found: "+ username);
		return user;
	}
}
