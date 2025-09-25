package com.todo.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.app.models.Tasks;
import com.todo.app.repository.TaskRepository;

@Service
public class TaskService {
	
	
	
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository =  taskRepository;
	}
	
	
	public List<Tasks> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Tasks CreateTask(Tasks task){
		return taskRepository.save(task);
	}

}
