package com.buthdev.demo.services;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buthdev.demo.dto.BorrowedDTO;
import com.buthdev.demo.exceptions.UserNotFoundException;
import com.buthdev.demo.model.Borrowed;
import com.buthdev.demo.model.enums.BorrowedStatus;
import com.buthdev.demo.repositories.BorrowedRepository;

@Service
public class BorrowedService {
	
	@Autowired
	private BorrowedRepository borrowedRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	public List<Borrowed> findAll(){
		return borrowedRepository.findAll();
	}
	
	public Borrowed findById(Long id) {
		return borrowedRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	
	public Borrowed createBorrowed(BorrowedDTO borrowedDto) {
		Borrowed borrowed = new Borrowed();
		convertToBorrowed(borrowedDto, borrowed);
		
		borrowed.setInitialDate(OffsetDateTime.now());
		borrowed.setStatus(BorrowedStatus.VALID);
		borrowed.setDevolutionDate(borrowed.getInitialDate().plusDays(3));
		
		return borrowedRepository.save(borrowed);
	}

	public Borrowed updateBorrowed(BorrowedDTO borrowedDto, Long id) {
		Borrowed borrowed = findById(id);
		convertToBorrowed(borrowedDto, borrowed);
		return borrowedRepository.save(borrowed);
	}
	
	public void deleteBorrowed(Long id) {
		findById(id);
		borrowedRepository.deleteById(id);
	}
	
	public List<Borrowed> findByExpiredDate() {
		  OffsetDateTime currentDate = OffsetDateTime.now();
		    List<Borrowed> expiredItems = borrowedRepository.findByDevolutionDateBefore(currentDate);

		    for (Borrowed borrowed : expiredItems) {
		        borrowed.setStatus(BorrowedStatus.EXPIRED);
		        borrowedRepository.save(borrowed);
		    }
		    
		    return expiredItems;
		}
	
	private Borrowed convertToBorrowed(BorrowedDTO borrowedDto, Borrowed borrowed) {
		borrowed.setUser(userService.findById(borrowedDto.getUserId()));
		borrowed.setBook(bookService.findById(borrowedDto.getBookId()));
		return borrowed;
	}
}