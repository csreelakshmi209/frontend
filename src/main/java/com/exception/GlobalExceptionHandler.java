package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


public class GlobalExceptionHandler {
	@ExceptionHandler(DuplicateEmployeeException.class)
	public ResponseEntity<?> duplicateEmployeeException(DuplicateEmployeeException ex, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchDonorException.class)
	public ResponseEntity<?> noSuchDonorException(NoSuchDonorException ex, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateDonorException.class)
	public ResponseEntity<?> duplicateDonorException(DuplicateDonorException ex, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchEmployeeException.class)
	public ResponseEntity<?> noSuchEmployeeException(NoSuchEmployeeException ex, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSuchNeedyPeopleException.class)
	public ResponseEntity<?> noSuchNeedyPeopleException(NoSuchNeedyPeopleException ex, WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) 
	{
		ErrorDetails errorDetails = new ErrorDetails (LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<> (errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}