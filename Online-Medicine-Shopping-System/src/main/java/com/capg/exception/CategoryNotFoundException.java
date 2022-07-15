package com.capg.exception;

public class CategoryNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2758159274055986263L;
	
	public CategoryNotFoundException(String message) {
		super(message);
	}
}
