package com.todo.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.models.Priorities;
import com.todo.app.services.PriorityService;

@RestController
@RequestMapping("priorities")
public class PriorityController {

	private final PriorityService priorityService;

	public PriorityController(PriorityService priorityService) {
		this.priorityService = priorityService;

	}

	@GetMapping(value = "/all")
	public List<Priorities> listOfPriorities(){
		
		return priorityService.getAll();
	}
}
