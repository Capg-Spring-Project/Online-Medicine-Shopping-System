package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class NoMedicinePresentException extends AuthenticationException {
	private static final long serialVersionUID = -981049022804116676L;

	public NoMedicinePresentException(String message) {
		super(message);
	}
}
