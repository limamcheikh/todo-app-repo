package com.todo.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.models.Categories;

public interface CategorieRepository extends JpaRepository<Categories,String>{

	Optional<Categories> findByNameIgnoreCase(String name);
}
