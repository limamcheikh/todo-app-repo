package com.todo.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	
	public Optional<User> findById(String userId);
	
	public List<User> findByName (String username);
	
	public List<User> findByNameStartingWith(String prefix);
}
