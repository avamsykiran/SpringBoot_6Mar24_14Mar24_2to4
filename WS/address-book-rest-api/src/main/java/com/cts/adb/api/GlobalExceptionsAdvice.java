package com.cts.adb.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.adb.exceptions.ContactNotFoundException;
import com.cts.adb.exceptions.InvalidContactDetalsException;

@RestControllerAdvice
public class GlobalExceptionsAdvice {
	
	private Logger logger;
	
	public GlobalExceptionsAdvice() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}

	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<String> handleContactNotFoundException(ContactNotFoundException exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidContactDetalsException.class)
	public ResponseEntity<String> handleInvalidContactDetalsException(InvalidContactDetalsException exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAnyOtherException(Exception exp){
		logger.error(exp.getMessage(), exp);
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
