package com.iyoa.cleanaddis.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ArchivedException extends Exception{
	
	public ArchivedException(String message) {
		super(message);
	}
	
	public ArchivedException(Throwable cause) {
		super(cause);
	}

	public ArchivedException(String message, Throwable cause) {
		super(message, cause);
	}
}
