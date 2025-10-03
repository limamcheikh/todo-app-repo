package com.todo.app.controllers;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.dto.TaskDTO;
import com.todo.app.models.Categories;
import com.todo.app.models.Priorities;
import com.todo.app.models.Tasks;
import com.todo.app.models.User;
import com.todo.app.repository.UserRepository;
import com.todo.app.services.CategorieService;
import com.todo.app.services.PriorityService;
import com.todo.app.services.TaskService;
import com.todo.app.services.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	
	private final TaskService taskservice;
	private final CategorieService catservice;
	private final PriorityService priorityservice;
	private final UserService userService;
	
	public TaskController(TaskService taskservice,CategorieService catservice,PriorityService priorityservice,UserService userService) {
		this.taskservice = taskservice;
		this.catservice = catservice;
		this.priorityservice = priorityservice;
		this.userService= userService;
	}
	
//	@GetMapping(value = "/all")
//	public List<Tasks> Tasks() {
//		return taskservice.getAllTasks();
//	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Tasks>> Tasks() {
		List<Tasks> tasks = taskservice.getAllTasks();
		
		
		return ResponseEntity.ok (tasks);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Tasks>> listTasksByUser(@PathVariable String userId){
	    List<Tasks> tasks = taskservice.getTaskByUserId(userId);
	    if(tasks.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.status(HttpStatus.CREATED).body(tasks);
	}
	
    // PATCH to update only "completed" field
    @PatchMapping("/{id}/toggle-completion")
    public ResponseEntity<Tasks> toggleTaskCompletion(
            @PathVariable String id,
            @RequestParam boolean completed) {

        Tasks updatedTask = taskservice.toggleTaskCompletion(id, completed);
        if (updatedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTask);
    }
    
    
    @DeleteMapping(value = "/delete/{taskId}")
    public ResponseEntity<Void>  deleteTask(@PathVariable String taskId){
    	
    	try {
    		taskservice.deleteTaskById(taskId);
    		return ResponseEntity.noContent().build();
    	}catch(Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    	
    }

	
//	@PostMapping(value = "/add")
//	public ResponseEntity<Tasks> addTask(@RequestBody @Valid Tasks task) {
//		
//	    // 🔍 Debugging all incoming values
//	    System.out.println("----- Incoming Task JSON -----");
//	    System.out.println("Title: " + task.getTitle());
//	    System.out.println("Description: " + task.getDescription());
//	    System.out.println("Due Date: " + task.getDueDate());
//	    System.out.println("Completed: " + task.isCompleted());
//
//	    if (task.getCategories() != null) {
//	        System.out.println("Category Name: " + task.getCategories().getName());
//	    } else {
//	        System.out.println("Category is NULL");
//	    }
//
//	    if (task.getPriorities() != null) {
//	        System.out.println("Priority Name: " + task.getPriorities().getName());
//	    } else {
//	        System.out.println("Priority is NULL");
//	    }
//
//	    if (task.getUser() != null) {
//	        System.out.println("User ID: " + task.getUser().getUserId());
//	        System.out.println("User Name: " + task.getUser().getName());
//	    } else {
//	        System.out.println("User is NULL");
//	    }
//	    System.out.println("-------------------------------");
//
//	    // 1. Find or create managed category
//	    Categories savedCat = catservice.findOrCreateByName(task.getCategories().getName());
//	    
//	    System.out.println(savedCat.toString());
//
//	    // 2. Find or create managed priority
//	    Priorities savedPrio = priorityservice.findOrCreateByName(task.getPriorities().getName());
//	    
//	    System.out.println(savedPrio.toString());
//
//	    // 3. Set managed entities into the task
//	    task.setCategories(savedCat);
//	    task.setPriorities(savedPrio);
//
//	    // 4. Save the task using repository to ensure entity is managed
//	    Tasks savedTask = taskservice.CreateTask(task);
//
//	    return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
//	}
	
	@PostMapping("/add")
	public ResponseEntity<Tasks> addTask(@RequestBody @Valid TaskDTO taskDTO) {

	    
		taskDTO.printAsJson();
		
		String categorieName = taskDTO.getCategories().getName();
		String priName = taskDTO.getPriorities().getName();
		
		Categories cat = catservice.findOrCreateByName(categorieName);
		Priorities p = priorityservice.findOrCreateByName(priName);
		
		Tasks task1 = new Tasks();
		task1.setTitle(taskDTO.getTitle());
		task1.setDescription(taskDTO.getDescription());
		task1.setDueDate(taskDTO.getDueDate());
		task1.setCompleted(false);
		task1.setCategories(cat);
		task1.setPriorities(p);
		task1.setUser(taskDTO.getUser());
		taskservice.CreateTask(task1);
		task1.printAsJson();
	    

	    return ResponseEntity.status(HttpStatus.CREATED).body(task1);
	}



}
