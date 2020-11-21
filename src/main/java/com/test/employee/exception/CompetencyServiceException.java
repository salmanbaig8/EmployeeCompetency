package com.test.employee.exception;

import com.test.employee.model.ExceptionType;

public class CompetencyServiceException extends RuntimeException {

	private static final long serialVersionUID = 8787264254616610521L;

	public CompetencyServiceException(String message, Throwable ex){
		 super(message, ex);
	}

	public CompetencyServiceException(ExceptionType type, String message){
		 super(type + " " + message);
	}
}
