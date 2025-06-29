package com.sprint1.ebs.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PaymentControllerAdvice {

	@ExceptionHandler(value=PaymentIdNotFoundException.class)
	public ResponseEntity<Object> exception(PaymentIdNotFoundException excep1){
    
		return new ResponseEntity<>("Payment Id not found",HttpStatus.NOT_FOUND);
	}
}
