package com.buthdev.demo.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "book_category",
	        joinColumns = @JoinColumn(name = "book_id"),
	        inverseJoinColumns = @JoinColumn(name = "category_id")
	    )
	private Set<Category> categories;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
}