package com.todo.app.models;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Tasks {
	
	@Id
    @GeneratedValue
    @UuidGenerator 
    @Column(updatable = false, nullable = false)
	private String taskId;
	@NotNull(message = "the Title cannot be empty please")
	@NotBlank
	private String title;
	private String description;
	private boolean completed;
	
	@NotNull(message = "the date cannot be empty please")
	@FutureOrPresent(message = "the date must be grater or equal the current date")
	private Date dueDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Categories categories;
	
	@ManyToOne
	private Priorities priorities;
	
	
	
	
	
	

	public Tasks() {
		super();
	}



	public Tasks(@NotNull(message = "the Title cannot be empty please") @NotBlank String title, String description,
			boolean completed,
			@NotNull(message = "the date cannot be empty please") @FutureOrPresent(message = "the date must be grater or equal the current date") Date dueDate) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.dueDate = dueDate;
	}



	public Tasks(@NotNull(message = "the Title cannot be empty please") @NotBlank String title, String description,
			boolean completed,
			@NotNull(message = "the date cannot be empty please") @FutureOrPresent(message = "the date must be grater or equal the current date") Date dueDate,
			User user, Categories categories, Priorities priorities) {
		super();
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.dueDate = dueDate;
		this.user = user;
		this.categories = categories;
		this.priorities = priorities;
	}



	public Tasks(String taskId, @NotNull(message = "the Title cannot be empty please") @NotBlank String title,
			String description, boolean completed,
			@NotNull(message = "the date cannot be empty please") @FutureOrPresent(message = "the date must be grater or equal the current date") Date dueDate,
			User user, Categories categories, Priorities priorities) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.dueDate = dueDate;
		this.user = user;
		this.categories = categories;
		this.priorities = priorities;
	}
	
	

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	

	
	
	
	
	
	
	

}
