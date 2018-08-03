package com.example.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.rest.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserId(final Integer userId);
}
