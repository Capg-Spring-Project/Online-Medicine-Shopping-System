package com.capg.exception;

public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1921809915216820919L;
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
