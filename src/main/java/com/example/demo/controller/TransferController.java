package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.entity.Transaction;
import com.example.demo.service.TransferService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TransferController {

	private final TransferService transferService;

	@PostMapping("/transfer")
	public ResponseEntity<Transaction> transfer(@RequestBody Transaction transaction) {
		return ResponseEntity.ok(transferService.transfer(transaction));
	}

}
