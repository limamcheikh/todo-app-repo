package com.todo.app.dto;

public class UpdateTaskRequest {
    private String title;
    private String description;
    private String dueDate;
    private String categoryId;
    private String priorityId;
    private String userId;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    
    public String getPriorityId() { return priorityId; }
    public void setPriorityId(String priorityId) { this.priorityId = priorityId; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}
