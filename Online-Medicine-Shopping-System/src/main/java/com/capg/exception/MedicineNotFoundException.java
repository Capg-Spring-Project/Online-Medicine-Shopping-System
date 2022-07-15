package com.capg.exception;

public class MedicineNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -602480044807642443L;
	
	public MedicineNotFoundException(String message) {
		super(message);
	}
}
