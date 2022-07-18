package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class AdminNotFoundException extends AuthenticationException {
	static final long serialVersionUID = -2240115913037426244L;

	public AdminNotFoundException(String message) {
		super(message);
	}
}