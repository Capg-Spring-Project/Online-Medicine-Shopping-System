package com.capg.exception;

public class InvalidCredentialsException extends RuntimeException {
	private static final long serialVersionUID = 1111952031707699010L;

	public InvalidCredentialsException(String message) {
		super(message);
	}
}
