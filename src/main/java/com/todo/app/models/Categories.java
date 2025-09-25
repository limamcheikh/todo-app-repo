package com.todo.app.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
public class Categories {
	
	@Id
    @GeneratedValue
    @UuidGenerator 
    @Column(updatable = false, nullable = false)
	private String categorieId;
	@NotBlank
	@NotNull
	private String name;

	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tasks> listOfTasksOfCategorie;
	
	
	public Categories() {}
	
	public Categories(String name) {
		this.name = name;
	}
	
	

	public Categories(String categorieId, @NotBlank @NotNull String name, List<Tasks> listOfTasksOfCategorie) {
		super();
		this.categorieId = categorieId;
		this.name = name;
		this.listOfTasksOfCategorie = listOfTasksOfCategorie;
	}
	
	



	public Categories(String categorieId, @NotBlank @NotNull String name) {
		super();
		this.categorieId = categorieId;
		this.name = name;
	}



	public String getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(String categorieId) {
		this.categorieId = categorieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tasks> getListOfTasksOfCategorie() {
		return listOfTasksOfCategorie;
	}

	public void setListOfTasksOfCategorie(List<Tasks> listOfTasksOfCategorie) {
		this.listOfTasksOfCategorie = listOfTasksOfCategorie;
	}
	
	
	
	
	
	
}
