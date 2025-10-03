package com.todo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.todo.app.models.Priorities;

public interface PriorityRepository extends JpaRepository<Priorities,String>{

	Optional<Priorities> findByNameIgnoreCase(String name);
}
