package com.capg.exception;

public class AdminNotFoundException extends RuntimeException {
	static final long serialVersionUID = -2240115913037426244L;

	public AdminNotFoundException(String message) {
		super(message);
	}
}