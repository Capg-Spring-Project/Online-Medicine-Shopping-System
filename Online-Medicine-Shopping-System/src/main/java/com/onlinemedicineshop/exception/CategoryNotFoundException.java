package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class CategoryNotFoundException extends AuthenticationException {
	private static final long serialVersionUID = -2758159274055986263L;
	
	public CategoryNotFoundException(String message) {
		super(message);
	}
}
