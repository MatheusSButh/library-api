package com.buthdev.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buthdev.demo.dto.CategoryDTO;
import com.buthdev.demo.exceptions.UserNotFoundException;
import com.buthdev.demo.model.Category;
import com.buthdev.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	public Category createCategory(CategoryDTO categoryDto) {
		Category category = new Category();
		convertToCategory(categoryDto, category);
		
		return categoryRepository.save(category);
	}

	public Category updateCategory(CategoryDTO categoryDto, Long id) {
		Category category = findById(id);
		convertToCategory(categoryDto, category);
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
		findById(id);
		categoryRepository.deleteById(id);
	}
	
	
	private Category convertToCategory(CategoryDTO categoryDto, Category category) {
		category.setName(categoryDto.getName());
		return category;
	}
}
