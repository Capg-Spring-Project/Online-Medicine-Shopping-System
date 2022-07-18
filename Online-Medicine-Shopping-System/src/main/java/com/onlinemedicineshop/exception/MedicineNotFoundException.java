package com.onlinemedicineshop.exception;

import org.springframework.security.core.AuthenticationException;

public class MedicineNotFoundException extends AuthenticationException {
	private static final long serialVersionUID = -602480044807642443L;
	
	public MedicineNotFoundException(String message) {
		super(message);
	}
}
