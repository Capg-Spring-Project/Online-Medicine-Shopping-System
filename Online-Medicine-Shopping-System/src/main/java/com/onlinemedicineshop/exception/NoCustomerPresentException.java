package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class NoCustomerPresentException extends AuthenticationException {	
	private static final long serialVersionUID = -6125014552383743618L;

	public NoCustomerPresentException(String message) {
		super(message);
	}
}
