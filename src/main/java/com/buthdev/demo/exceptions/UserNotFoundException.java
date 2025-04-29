package com.buthdev.demo.exceptions;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
		super("Entity with ID " + id + " not found");
	}
}
