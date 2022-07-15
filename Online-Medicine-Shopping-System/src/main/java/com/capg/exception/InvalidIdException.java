package com.capg.exception;

public class InvalidIdException extends RuntimeException {
	private static final long serialVersionUID = 3064509364633952883L;

	public InvalidIdException(String message) {
		super(message);
	}
}