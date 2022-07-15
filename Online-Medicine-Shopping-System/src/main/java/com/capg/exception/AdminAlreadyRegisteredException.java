package com.capg.exception;

public class AdminAlreadyRegisteredException extends RuntimeException {
	private static final long serialVersionUID = -6088872306605007911L;
	
	public AdminAlreadyRegisteredException(String message) {
		super(message);
	}
}
