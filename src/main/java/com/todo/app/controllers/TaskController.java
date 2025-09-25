package com.todo.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.models.Tasks;
import com.todo.app.services.TaskService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	
	private final TaskService taskservice;
	
	public TaskController(TaskService taskservice) {
		this.taskservice = taskservice;
	}
	
//	@GetMapping(value = "/all")
//	public List<Tasks> Tasks() {
//		return taskservice.getAllTasks();
//	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<?> Tasks() {
		List<Tasks> tasks = taskservice.getAllTasks();
		
		if(tasks.isEmpty()) {
			return ResponseEntity.ok("No tasks available");
		}
		return ResponseEntity.ok (tasks);
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addTask(@RequestBody @Valid Tasks task){
		
	    Tasks savedTask = taskservice.CreateTask(task);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
	}
}
