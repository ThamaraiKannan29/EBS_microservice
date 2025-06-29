package com.sprint1.ebs.connection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EbsConnectionControllerAdvice {

	@ExceptionHandler(value=EbsConnectionIDNotFoundException.class)
	public ResponseEntity<Object> exception(EbsConnectionIDNotFoundException excep1){
		return new ResponseEntity<>("Connection Id not found",HttpStatus.NOT_FOUND);
	}
}