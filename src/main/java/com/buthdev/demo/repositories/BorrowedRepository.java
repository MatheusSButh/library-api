package com.buthdev.demo.repositories;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buthdev.demo.model.Borrowed;

public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

	List<Borrowed> findByDevolutionDateBefore(OffsetDateTime currentDate);

}
