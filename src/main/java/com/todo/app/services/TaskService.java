package com.todo.app.services;

import java.util.List;
import java.util.Optional;

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
	
	public List<Tasks> getTaskByUserId(String userId) {
		return taskRepository.findByUser_UserId(userId);
	}
	
	public Tasks toggleTaskCompletion(String taskId,boolean completed) {
		
		Optional<Tasks> task = taskRepository.findById(taskId);
		
		if(task.isEmpty()) {
			return null;
		}
		
		Tasks taskupdated = task.get();
		taskupdated.setCompleted(completed);
		
		return taskRepository.save(taskupdated);
		 
	}
	
	public void deleteTaskById(String taskId) {
		 taskRepository.deleteById(taskId);
	}

}
