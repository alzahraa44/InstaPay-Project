package com.example.demo.controller.advice.helper;

import lombok.Data;

@Data
public class ErrorResponse {
	int code;
	String message;
	String details;
}
