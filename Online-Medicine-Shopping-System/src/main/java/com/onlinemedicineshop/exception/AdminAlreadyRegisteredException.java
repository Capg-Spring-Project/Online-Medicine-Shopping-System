package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class AdminAlreadyRegisteredException extends AuthenticationException {
	private static final long serialVersionUID = -6088872306605007911L;
	
	public AdminAlreadyRegisteredException(String message) {
		super(message);
	}
}
