package com.iyoa.cleanaddis.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends Exception {

	public UnauthorizedException(String message) {
		super(message);
	}
	
	public UnauthorizedException(Throwable cause) {
		super(cause);
	}

	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
