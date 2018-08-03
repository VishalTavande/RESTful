package com.example.spring.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.rest.model.User;
import com.example.spring.rest.repository.UserRepository;

@Service
public class UserDAOBean implements UserDAO {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		if(userRepository != null)
			return userRepository.findAll();
		return null;
	}

	@Override
	public User getUser(Integer id) {
		return userRepository.findByUserId(id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void removeUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

}
