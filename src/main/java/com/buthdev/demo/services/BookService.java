package com.buthdev.demo.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buthdev.demo.dto.BookDTO;
import com.buthdev.demo.exceptions.NotFoundException;
import com.buthdev.demo.model.Book;
import com.buthdev.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private CategoryService categoryService;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book findById(Long id) {
		return bookRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
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
		if (bookDto.authorId() == null) {
	        throw new NotFoundException(bookDto.authorId());
	    }
		
		BeanUtils.copyProperties(bookDto, book);
		book.setAuthor(authorService.findById(bookDto.authorId()));
		book.setCategories(new HashSet<>(categoryService.findAllById(bookDto.categoryId())));
		return book;
	}
}