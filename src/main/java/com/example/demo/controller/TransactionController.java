package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.entity.Transaction;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService transactionService;

	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		return ResponseEntity.ok(transactionService.getAllTransactions());

	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
		return ResponseEntity.ok(transactionService.getTransactionById(id));
	}

}
