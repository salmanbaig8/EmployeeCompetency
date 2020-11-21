package com.test.employee.exception;

import com.test.employee.model.ExceptionType;

public class EmployeeServiceException extends RuntimeException {

	private static final long serialVersionUID = 8787264254616610521L;

	public EmployeeServiceException(String message, Throwable ex){
		 super(message, ex);
	}

	public EmployeeServiceException(ExceptionType type, String message){
		 super(type + " " + message);
	}
}
