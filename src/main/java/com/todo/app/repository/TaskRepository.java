package com.todo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.app.models.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, String>{

	List<Tasks> findByUser_UserId(String userId);
}
