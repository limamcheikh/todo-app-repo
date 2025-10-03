package com.todo.app.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.app.models.Priorities;
import com.todo.app.models.User;
import com.todo.app.repository.UserRepository;

@Service
public class UserService {

	
	
	private final UserRepository userrepository;
	
	public UserService(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	
	public User createUser(User user) {
		
		return userrepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userrepository.findAll();
	}
	
	public User getUserById(String userId) {
		return userrepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
	}
	
    public User findOrCreateByName(User user) {
        // Try to find the priority first (case-insensitive)
    	String username = user.getName();
        return userrepository.findByNameIgnoreCase(username)
                .orElseGet(() -> {
                    // Create new entity if not found
                    User newuser = new User();
                    newuser.setName(username);
                    return userrepository.save(newuser); // save managed entity
                });
    }
    
    
	
}
