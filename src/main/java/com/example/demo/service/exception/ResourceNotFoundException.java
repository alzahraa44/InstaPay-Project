package com.example.demo.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3600878458274466469L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
