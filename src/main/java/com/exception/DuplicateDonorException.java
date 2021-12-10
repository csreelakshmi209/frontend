package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


public class DuplicateDonorException extends Exception{

	public DuplicateDonorException(String string) {
		super(string);
	}
	
}