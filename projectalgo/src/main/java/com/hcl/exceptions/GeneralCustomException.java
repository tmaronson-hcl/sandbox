package com.hcl.exceptions;

public class GeneralCustomException extends Exception {

	public GeneralCustomException() {
		
	}

	public GeneralCustomException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public GeneralCustomException(String message) {
		super(message);
	}
	
	

}
