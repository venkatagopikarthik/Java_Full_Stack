package com.example.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.dao.UserRepository;
import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.model.UserPrinciple;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
@Autowired
UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrinciple(user);
	}
	

}
