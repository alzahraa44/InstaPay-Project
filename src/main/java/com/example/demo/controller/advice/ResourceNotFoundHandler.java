package com.example.demo.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.controller.advice.helper.ErrorResponse;
import com.example.demo.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(ResourceNotFoundException r) {
		ErrorResponse er = new ErrorResponse();
		er.setCode(-1);
		er.setMessage(r.getMessage());
		er.setDetails("Details");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}

}
