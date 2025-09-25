package com.todo.app.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.app.models.User;
import com.todo.app.repository.UserRepository;

@Service
public class UserService {

	
	
	private final UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	
	public User createUser(User user) {
		
		return repository.save(user);
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User getUserById(String userId) {
		return repository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
	}
	
	public List<User> getUserByUsername(String username) {
		return repository.findByName(username);
	}
	
    public User getOneUserByName(String name) {
        return repository.findByName(name)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with name '" + name + "' not found"));
    }
    
    public List<User> getUsersByGivingName(String name){
    	return repository.findByNameStartingWith(name);
    }
	
}
