package com.example.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.dao.UserRepository;
import com.example.SpringSecurity.model.User;

@Service
public class UserService {
	@Autowired
    private UserRepository repo;
	private BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(12);
	
	public User registerUser(User user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return repo.save(user);
	}
	
	
}
