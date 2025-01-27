package com.example.SpringSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByUsername(String username);

}
