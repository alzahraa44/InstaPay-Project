package com.example.demo.service.exception;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 4310529664145785771L;

	public InsufficientBalanceException(String message) {
		super(message);
	}

}
