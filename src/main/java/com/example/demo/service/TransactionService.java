package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.Transaction;
import com.example.demo.database.repository.TransactionRepository;
import com.example.demo.service.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

	private final TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();

	}

	public Transaction getTransactionById(Integer id) {
		return transactionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Your transaction: not found"));
	}

}
