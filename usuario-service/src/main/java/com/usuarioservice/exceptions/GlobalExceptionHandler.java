package com.usuarioservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ErrorDetails error = ErrorDetails.builder().message(message).succes(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}

}
