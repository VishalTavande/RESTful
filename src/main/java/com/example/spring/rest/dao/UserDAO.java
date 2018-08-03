package com.example.spring.rest.dao;

import java.util.List;

import com.example.spring.rest.model.User;

public interface UserDAO {
	
	public List<User> getUsers();
	
	public User getUser(final Integer id);
	
	public User saveUser(final User user);
	
	public User updateUser(final User user);
	
	public void removeUser(final Integer id);

}
