package com.todo.app.models;


import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;




@Entity
public class User {
	
	
    @Id
    @GeneratedValue
    @UuidGenerator 
    @Column(updatable = false, nullable = false)
	private String userId;
	@NotNull
	@NotBlank
	@Column(length = 50)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tasks> listOfTaskesOfUser;
	
	
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	
	
	

	public User(String userId, @NotNull @NotBlank String name) {
		super();
		this.userId = userId;
		this.name = name;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tasks> getListOfTaskesOfUser() {
		return listOfTaskesOfUser;
	}

	public void setListOfTaskesOfUser(List<Tasks> listOfTaskesOfUser) {
		this.listOfTaskesOfUser = listOfTaskesOfUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", listOfTaskesOfUser=" + listOfTaskesOfUser + "]";
	}
	
	
	
	
	
	

}
