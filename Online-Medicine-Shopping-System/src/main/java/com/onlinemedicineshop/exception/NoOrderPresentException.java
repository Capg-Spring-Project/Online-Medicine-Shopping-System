package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class NoOrderPresentException extends AuthenticationException {	
	private static final long serialVersionUID = -6469168452023445142L;

	public NoOrderPresentException(String message) {
		super(message);
	}
}
