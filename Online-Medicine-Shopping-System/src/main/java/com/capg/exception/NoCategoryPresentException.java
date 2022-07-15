package com.capg.exception;

public class NoCategoryPresentException extends RuntimeException {	
	private static final long serialVersionUID = 2402028545268154354L;

	public NoCategoryPresentException(String message) {
		super(message);
	}
}
