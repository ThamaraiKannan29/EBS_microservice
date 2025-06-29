package com.sprint1.ebs.user.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerControllerAdvice {

	@ExceptionHandler(value=CustomerIdNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerIdNotFoundException excep){
    
		return new ResponseEntity<>("Customer Id not found",HttpStatus.NOT_FOUND);
	}
}
