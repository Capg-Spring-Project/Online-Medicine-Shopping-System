package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidIdException extends AuthenticationException {
	private static final long serialVersionUID = 3064509364633952883L;

	public InvalidIdException(String message) {
		super(message);
	}
}