package com.autogeneral.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		DetailsValidationError details = new DetailsValidationError ("params","text","Must be between 1 and 50 chars long","");
		ExceptionResponse<DetailsValidationError> exceptionResponse = new ExceptionResponse<DetailsValidationError>(details,"ValidationError");
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ToDoNotFoundException.class)
	public final ResponseEntity<Object> handleToDoNotFound(ToDoNotFoundException ex, WebRequest request){
		DetailsNotFound details = new DetailsNotFound ("Item with " + ex.getMessage() + " not found");
		ExceptionResponse<DetailsNotFound> exceptionResponse = new ExceptionResponse<DetailsNotFound>(details,"NotFoundError");
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
