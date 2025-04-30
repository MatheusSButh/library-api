package com.buthdev.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buthdev.demo.model.Borrowed;

public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

}
