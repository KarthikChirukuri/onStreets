package com.onStreets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.onStreets.entity.User;
import com.onStreets.repository.UserRepository;
import com.onStreets.security.JwtUtil;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public String login(String email, String password) {
		User user = userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("user not found!"));
		if(!encoder.matches(password, user.getPassword())) {
			 throw new RuntimeException("Invalid password");
		}
		return jwtUtil.generateToken(email);
	}
	
}
