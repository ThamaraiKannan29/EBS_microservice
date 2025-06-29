package com.sprint1.ebs.connection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EbsCustomerControllerAdvice {

	@ExceptionHandler(value=EbsCustomerIDNotFoundException.class)
	public ResponseEntity<Object> exception(EbsCustomerIDNotFoundException excep1){
		return new ResponseEntity<>("Customer Id not found",HttpStatus.NOT_FOUND);
	}
}