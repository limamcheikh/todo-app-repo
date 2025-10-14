package com.todo.app.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.app.models.Categories;
import com.todo.app.models.Priorities;
import com.todo.app.models.User;

import jakarta.validation.constraints.NotNull;

public class TaskDTO {

	@NotNull(message = "Title cannot be null")
	private String title;

	private String description;

	@NotNull(message = "Due date cannot be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dueDate;

	private boolean completed;

	private Categories categories; // match "categories" JSON
	private Priorities priorities; // match "priorities" JSON
	private User user; // Only the name

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Priorities getPriorities() {
		return priorities;
	}

	public void setPriorities(Priorities priorities) {
		this.priorities = priorities;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void printAsJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert this object to JSON string
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			System.out.println(json);
			System.out.println("----");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
