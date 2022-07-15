package com.capg.exception;

public class NoMedicinePresentException extends RuntimeException {
	private static final long serialVersionUID = -981049022804116676L;

	public NoMedicinePresentException(String message) {
		super(message);
	}
}
