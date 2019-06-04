package com.iyoa.cleanaddis.error;

public class SaveEntityException extends Exception {

	private static final long serialVersionUID = 1L;

	public SaveEntityException(String message) {
		super(message);
	}

	public SaveEntityException(Throwable cause) {
		super(cause);
	}

	public SaveEntityException(String message, Throwable cause) {
		super(message, cause);
	}
}