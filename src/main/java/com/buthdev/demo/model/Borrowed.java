package com.buthdev.demo.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor	
public class Borrowed {
	
	private User user;
	private Book book;
	private OffsetDateTime initialDate;
	private OffsetDateTime devolutionDate;
}
