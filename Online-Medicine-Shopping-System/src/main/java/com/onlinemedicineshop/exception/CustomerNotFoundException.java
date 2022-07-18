package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomerNotFoundException extends AuthenticationException {
	private static final long serialVersionUID = 1921809915216820919L;
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
