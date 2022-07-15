package com.capg.exception;

public class NoCustomerPresentException extends RuntimeException {	
	private static final long serialVersionUID = -6125014552383743618L;

	public NoCustomerPresentException(String message) {
		super(message);
	}
}
