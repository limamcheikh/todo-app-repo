package com.todo.app.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Priorities {

	@Id
    @GeneratedValue
    @UuidGenerator 
    @Column(updatable = false, nullable = false)
	private String prioritieId;
	@NotNull
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "priorities" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tasks> listOfTasksOfPrioritie;
	
	
	public Priorities() {}
	
	public Priorities(String name) {
		this.name = name;
	}
	
	
	
	

	public Priorities(String prioritieId, @NotNull String name) {
		super();
		this.prioritieId = prioritieId;
		this.name = name;
	}

	public Priorities(String prioritieId, @NotNull String name, List<Tasks> listOfTasksOfPrioritie) {
		super();
		this.prioritieId = prioritieId;
		this.name = name;
		this.listOfTasksOfPrioritie = listOfTasksOfPrioritie;
	}

	public String getPrioritieId() {
		return prioritieId;
	}

	public void setPrioritieId(String prioritieId) {
		this.prioritieId = prioritieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tasks> getListOfTasksOfPrioritie() {
		return listOfTasksOfPrioritie;
	}

	public void setListOfTasksOfPrioritie(List<Tasks> listOfTasksOfPrioritie) {
		this.listOfTasksOfPrioritie = listOfTasksOfPrioritie;
	}
	
	
	
	
	
}
