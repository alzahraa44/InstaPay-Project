package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.controller.advice.helper.ErrorResponse;
import com.example.demo.service.exception.InsufficientBalanceException;

@ControllerAdvice
public class TransferExceptionHandler {

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handle(InsufficientBalanceException i) {
		ErrorResponse er = new ErrorResponse();
		er.setCode(-100);
		er.setMessage(i.getMessage());
		er.setDetails("Details");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}

}
