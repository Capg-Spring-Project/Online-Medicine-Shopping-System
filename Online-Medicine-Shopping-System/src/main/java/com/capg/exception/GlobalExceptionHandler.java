package com.capg.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	// Customer Exceptions
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCustomerNotFoundExeption(CustomerNotFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoCustomerPresentException.class)
	public ResponseEntity<ErrorDetails> handleNoCustomerPresentException(NoCustomerPresentException exception,WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// Medicine Exceptions
	@ExceptionHandler(MedicineNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleMedicineNotFoundExeption(MedicineNotFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoMedicinePresentException.class)
	public ResponseEntity<ErrorDetails> handleNoMedicinePresentException(NoMedicinePresentException exception,WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// Category Exceptions
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCategoryNotFoundExeption(CategoryNotFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoCategoryPresentException.class)
	public ResponseEntity<ErrorDetails> handleNoCategoryPresentException(NoCategoryPresentException exception,WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// Order Exceptions
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleOrderNotFoundExeption(OrderNotFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoOrderPresentException.class)
	public ResponseEntity<ErrorDetails> handleNoOrderPresentException(NoOrderPresentException exception,WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	// Admin Exceptions	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAdminNotFoundExeption(AdminNotFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdminAlreadyRegisteredException.class)
	public ResponseEntity<ErrorDetails> handleAdminAlreadyRegisteredException(AdminAlreadyRegisteredException exception,WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.CONFLICT);
	}
	
	// Common Exceptions
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ErrorDetails> handleInvalidIdException(InvalidIdException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorDetails> handleInvalidCredentialsException(InvalidCredentialsException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
