package com.nixsolutions.controller.rest;

public class UserNotExistException extends RuntimeException {
	
	public UserNotExistException(String message) {
		        super(message);
		    }
}
