package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class OrderNotFoundException extends AuthenticationException {
	private static final long serialVersionUID = -3241780899946747676L;
	
	public OrderNotFoundException(String message) {
		super(message);
	}

}
