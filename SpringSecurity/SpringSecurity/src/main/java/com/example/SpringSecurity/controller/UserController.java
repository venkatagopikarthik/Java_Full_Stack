package com.example.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user);
		
	}

}
