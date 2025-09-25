package com.todo.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.models.User;
import com.todo.app.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	
	private final UserService userservice;
	
	public UserController(UserService userservice) {
		this.userservice = userservice;
	}

	
	
	@GetMapping(value = "/index")
	
	public String index() {
		return "hello from limam";
	}
	
	@GetMapping(value = "/all")
	public List<User> getAllUsers(){
		
		return userservice.getAllUsers();
	}
	
	@PostMapping(value = "/add")
	public User addUser(@RequestBody User user) {
		return userservice.createUser(user);
	}
	
	@GetMapping(value = "/{name}")
	public List<User> getUserByTheName(@PathVariable String name) {
		return userservice.getUsersByGivingName(name);
	}
}
