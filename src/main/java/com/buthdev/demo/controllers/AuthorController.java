package com.buthdev.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buthdev.demo.dto.AuthorDTO;
import com.buthdev.demo.model.Author;
import com.buthdev.demo.services.AuthorService;

@RestController
@RequestMapping(value = "authors")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		return ResponseEntity.ok().body(authorService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Author> createAuthor(@RequestBody AuthorDTO authorDto) {
		authorService.createAuthor(authorDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Author> updateAuthor (@RequestBody AuthorDTO authorDto, @PathVariable Long id) {
		authorService.updateAuthor(authorDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}