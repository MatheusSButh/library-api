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

import com.buthdev.demo.dto.BookDTO;
import com.buthdev.demo.model.Book;
import com.buthdev.demo.services.BookService;

@RestController
@RequestMapping(value = "books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.ok().body(bookService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(bookService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Book> createbook(@RequestBody BookDTO bookDto) {
		bookService.createBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> updatebook (@RequestBody BookDTO bookDto, @PathVariable Long id) {
		bookService.updateBook(bookDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}