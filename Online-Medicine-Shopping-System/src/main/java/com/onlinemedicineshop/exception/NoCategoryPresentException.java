package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class NoCategoryPresentException extends AuthenticationException {	
	private static final long serialVersionUID = 2402028545268154354L;

	public NoCategoryPresentException(String message) {
		super(message);
	}
}
