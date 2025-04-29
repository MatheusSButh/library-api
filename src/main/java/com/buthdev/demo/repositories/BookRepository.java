package com.buthdev.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buthdev.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
