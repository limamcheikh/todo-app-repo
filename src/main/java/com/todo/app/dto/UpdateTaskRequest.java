package com.todo.app.dto;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.app.models.Categories;
import com.todo.app.models.Priorities;

public class UpdateTaskRequest {
	private String taskId;
    private String title;
    private String description;
    private Boolean completed;
    private Date dueDate;
    private Categories categories;
    private Priorities priorities;
   
    
    
    public UpdateTaskRequest() {}
    
    

   
	public UpdateTaskRequest(String taskId, String title, String description, Boolean completed, Date dueDate,
			Categories categories, Priorities priorities) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.dueDate = dueDate;
		this.categories = categories;
		this.priorities = priorities;
	}
	// Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
    
   
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	

	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categorie) {
		this.categories = categorie;
	}
	public Priorities getPriorities() {
		return priorities;
	}
	public void setPriorities(Priorities prioritie) {
		this.priorities = prioritie;
	}
	
	public void printAsJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert this object to JSON string
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
