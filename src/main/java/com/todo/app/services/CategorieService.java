package com.todo.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.app.models.Categories;
import com.todo.app.repository.CategorieRepository;

@Service
public class CategorieService {

	private final CategorieRepository categorieRepository;
	
	public CategorieService(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	
	
    public Categories findOrCreateByName(String name) {
        return categorieRepository.findByNameIgnoreCase(name)
                .orElseGet(() -> {
                    Categories newCat = new Categories();
                    newCat.setName(name);
                    return categorieRepository.save(newCat);
                });
    }
    
    public List<Categories> getAll(){
    	return categorieRepository.findAll();
    }
}
