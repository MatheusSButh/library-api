package com.buthdev.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buthdev.demo.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	List<Author> findByNameContainingIgnoreCase(String name);

}
