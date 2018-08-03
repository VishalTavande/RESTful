package com.example.spring.rest.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.rest.dao.UserDAO;
import com.example.spring.rest.model.User;

@RestController
@RequestMapping("/rest")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
		
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") final Integer id) {
		if(id == null)
			return ResponseEntity.badRequest().build();

		User user = userDAO.getUser(id);
		if(user == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(user);
	}
	

	@GetMapping("/users")
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		if(user == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(userDAO.saveUser(user));
	}
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name="id") final Integer id,
			@Valid @RequestBody User user) {
		if(user == null)
			return ResponseEntity.badRequest().build();
		
		User existingUser = userDAO.getUser(id);
		if(existingUser == null)
			return ResponseEntity.notFound().build();
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setDateOfBirth(user.getDateOfBirth());
		
		return ResponseEntity.ok().body(userDAO.saveUser(existingUser));
	}

	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> removeUser(@PathVariable("id") final Integer id) {
		if(id == null)
			return ResponseEntity.badRequest().build();

		User user = userDAO.getUser(id);
		if(user == null)
			return ResponseEntity.notFound().build();
		
		userDAO.removeUser(id);
		return ResponseEntity.ok().build();
	}
	
}
