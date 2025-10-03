package com.todo.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.models.Tasks;
import com.todo.app.models.User;
import com.todo.app.services.UserService;

import jakarta.validation.Valid;


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
	
//	@PostMapping(value = "/add")
//	public ResponseEntity<User> addUser(@RequestBody  @Valid User user) {
//		
//	    User savedUser = userservice.createUser(user);
//	    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
//	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
	    
	    // Find existing user or create a new one
	    User savedUser = userservice.findOrCreateByName(user);

	    if (savedUser == null) {
	        return ResponseEntity.noContent().build(); // 204 No Content if creation failed
	    }

	    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}


}
