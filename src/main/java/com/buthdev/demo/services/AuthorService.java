package com.buthdev.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buthdev.demo.dto.AuthorDTO;
import com.buthdev.demo.exceptions.UserNotFoundException;
import com.buthdev.demo.model.Author;
import com.buthdev.demo.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
	
	public Author findById(Long id) {
		return authorRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	public Author createAuthor(AuthorDTO authorDto) {
		Author author = new Author();
		convertToAuthor(authorDto, author);
		
		return authorRepository.save(author);
	}

	public Author updateAuthor(AuthorDTO authorDto, Long id) {
		Author author = findById(id);
		convertToAuthor(authorDto, author);
		return authorRepository.save(author);
	}
	
	public void deleteAuthor(Long id) {
		findById(id);
		authorRepository.deleteById(id);
	}
	
	
	private Author convertToAuthor(AuthorDTO authorDto, Author author) {
		author.setName(authorDto.name());
		return author;
	}
}
