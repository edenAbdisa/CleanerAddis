package com.iyoa.cleanaddis.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidParameterFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidParameterFormatException(String message) {
		super(message);
	}

	public InvalidParameterFormatException(Throwable cause) {
		super(cause);
	}

	public InvalidParameterFormatException(String message, Throwable cause) {
		super(message, cause);
	}
}