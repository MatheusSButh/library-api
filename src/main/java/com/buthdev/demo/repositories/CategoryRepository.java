package com.buthdev.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buthdev.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
