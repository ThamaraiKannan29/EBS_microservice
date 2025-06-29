package com.sprint1.ebs.user.exception;

@SuppressWarnings("serial")
public class CustomerIdNotFoundException extends Exception {

	public CustomerIdNotFoundException(String message) {
		super(message);
	}
	public CustomerIdNotFoundException() {
		super();
	}
}
