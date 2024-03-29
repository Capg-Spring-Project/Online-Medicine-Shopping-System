package com.onlinemedicineshop.exception;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	// Security Exceptions
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ErrorDetails> handleInvalidIdException(InvalidIdException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorDetails> handleInvalidCredentialsException(InvalidCredentialsException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(DuplicateEmailInsertionException.class)
	public ResponseEntity<ErrorDetails> handleDuplicateEmailInsertionException(DuplicateEmailInsertionException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(UnauthorizedAccessException.class)
	public ResponseEntity<ErrorDetails> handleUnauthorizedAccessException(UnauthorizedAccessException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.UNAUTHORIZED);
	}
	
	//Validation Exception Handler
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
    	String message = exception.getBindingResult().getAllErrors()
    			.stream()
    			.map(p -> p.getDefaultMessage())
    			.collect(Collectors.joining(", "));
    	ErrorDetails errorDetails = new ErrorDetails(new Date(), message, request.getDescription(false));
    	return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
