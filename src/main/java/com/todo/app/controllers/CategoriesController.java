package com.todo.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.models.Categories;
import com.todo.app.services.CategorieService;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {

	private final CategorieService cateservice;
	
	
	public CategoriesController(CategorieService cateservice) {
		this.cateservice = cateservice;
	}
	
	@GetMapping(value = "/all")
	public List<Categories> listOfCategories(){
		return cateservice.getAll();
	}
}
