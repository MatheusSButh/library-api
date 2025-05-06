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

import com.buthdev.demo.dto.BorrowedDTO;
import com.buthdev.demo.model.Borrowed;
import com.buthdev.demo.services.BorrowedService;

@RestController
@RequestMapping(value = "borrowed")
public class BorrowedController {

	@Autowired
	BorrowedService borrowedService;
	
	@GetMapping
	public ResponseEntity<List<Borrowed>> findAll() {
		return ResponseEntity.ok().body(borrowedService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Borrowed> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(borrowedService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Borrowed> createBorrowed(@RequestBody BorrowedDTO borrowedDto) {
		borrowedService.createBorrowed(borrowedDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Borrowed> updateBorrowed (@RequestBody BorrowedDTO borrowedDto, @PathVariable Long id) {
		borrowedService.updateBorrowed(borrowedDto, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBorrowed(@PathVariable Long id) {
		borrowedService.deleteBorrowed(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}