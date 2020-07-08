package com.xangars.restdemoone.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity handleStudentNotFoundException(Exception e, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleAllExceptions(Exception e, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	
}
