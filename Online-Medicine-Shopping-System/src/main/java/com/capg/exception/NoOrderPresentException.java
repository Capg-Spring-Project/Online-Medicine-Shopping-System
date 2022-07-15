package com.capg.exception;

public class NoOrderPresentException extends RuntimeException {	
	private static final long serialVersionUID = -6469168452023445142L;

	public NoOrderPresentException(String message) {
		super(message);
	}
}
