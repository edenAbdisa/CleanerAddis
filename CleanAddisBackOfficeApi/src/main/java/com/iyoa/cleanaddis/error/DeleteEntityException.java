package com.iyoa.cleanaddis.error;

public class DeleteEntityException extends Exception {

	private static final long serialVersionUID = 1L;

	public DeleteEntityException(String message) {
		super(message);
	}

	public DeleteEntityException(Throwable cause) {
		super(cause);
	}

	public DeleteEntityException(String message, Throwable cause) {
		super(message, cause);
	}
}