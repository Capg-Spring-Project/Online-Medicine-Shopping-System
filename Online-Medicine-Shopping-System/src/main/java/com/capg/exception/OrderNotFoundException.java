package com.capg.exception;

public class OrderNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -3241780899946747676L;
	
	public OrderNotFoundException(String message) {
		super(message);
	}

}
