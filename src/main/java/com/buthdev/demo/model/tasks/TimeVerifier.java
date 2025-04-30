package com.buthdev.demo.model.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.buthdev.demo.services.BorrowedService;

@Component
public class TimeVerifier {

	@Autowired
    private BorrowedService borrowedService;

    @Scheduled(fixedRate = 3600000)
    public void verifyExpiredBorrowed() {
        borrowedService.findByExpiredDate();
    }
}
