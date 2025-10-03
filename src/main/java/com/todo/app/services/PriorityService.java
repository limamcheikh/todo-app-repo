package com.todo.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.app.models.Priorities;

import com.todo.app.repository.PriorityRepository;

@Service
public class PriorityService {

	
	private final PriorityRepository priorityRepository;
	
	public PriorityService(PriorityRepository priorityRepository) {
		this.priorityRepository = priorityRepository;
	}
	
	// PriorityService
    public Priorities findOrCreateByName(String name) {
        // Try to find the priority first (case-insensitive)
        return priorityRepository.findByNameIgnoreCase(name)
                .orElseGet(() -> {
                    // Create new entity if not found
                    Priorities newPriority = new Priorities();
                    newPriority.setName(name);
                    return priorityRepository.save(newPriority); // save managed entity
                });
    }
    
    
    public List<Priorities> getAll() {
    	return priorityRepository.findAll();
    }

	
	
}
