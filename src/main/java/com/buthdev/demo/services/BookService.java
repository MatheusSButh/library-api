package com.buthdev.demo.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buthdev.demo.dto.BookDTO;
import com.buthdev.demo.exceptions.UserNotFoundException;
import com.buthdev.demo.model.Book;
import com.buthdev.demo.repositories.BookRepository;
import com.buthdev.demo.repositories.CategoryRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book findById(Long id) {
		return bookRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	public Book createBook(BookDTO bookDto) {
		Book book = new Book();
		convertToBook(bookDto, book);
		
		return bookRepository.save(book);
	}

	public Book updateBook(BookDTO bookDto, Long id) {
		Book book = findById(id);
		convertToBook(bookDto, book);
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		findById(id);
		bookRepository.deleteById(id);
	}
	
	
	private Book convertToBook(BookDTO bookDto, Book book) {
		if (bookDto.getAuthorId() == null) {
	        throw new UserNotFoundException(bookDto.getAuthorId());
	    }
		
		book.setName(bookDto.getName());
		book.setAuthor(authorService.findById(bookDto.getAuthorId()));
		book.setCategories(new HashSet<>(categoryRepository.findAllById(bookDto.getCategoryId())));
		return book;
	}
}