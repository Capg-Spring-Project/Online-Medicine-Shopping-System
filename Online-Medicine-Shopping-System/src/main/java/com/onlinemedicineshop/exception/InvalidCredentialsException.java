package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {
	private static final long serialVersionUID = 1111952031707699010L;

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
