package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class DuplicateEmailInsertionException extends AuthenticationException {

	private static final long serialVersionUID = -6069753183611438144L;

	public DuplicateEmailInsertionException(String msg) {
		super(msg);
	}

}
