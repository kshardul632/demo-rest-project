package com.xangars.restdemoone.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {}

	public StudentNotFoundException(String arg0) {
		super(arg0);
	}

}
