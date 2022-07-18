package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class UnauthorizedAccessException extends AuthenticationException {
	private static final long serialVersionUID = 4045658858790528752L;

	public UnauthorizedAccessException(String message) {
		super(message);
	}
}