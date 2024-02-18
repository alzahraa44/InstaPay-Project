package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.database.entity.Account;
import com.example.demo.database.entity.Transaction;
import com.example.demo.database.repository.AccountRepository;
import com.example.demo.database.repository.TransactionRepository;
import com.example.demo.service.exception.InsufficientBalanceException;
import com.example.demo.service.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public Transaction transfer(Transaction transaction) {
		Account fromAccount = accountRepository.findById(transaction.getFromAccount()).orElseThrow(
				() -> new ResourceNotFoundException("Your Account: " + transaction.getFromAccount() + "not found"));
		Account toAccount = accountRepository.findById(transaction.getToAccount()).orElseThrow(
				() -> new ResourceNotFoundException("Your Account: " + transaction.getToAccount() + "not found"));

		if (fromAccount.getBalance() < transaction.getBalance()) {
			throw new InsufficientBalanceException("Your balance is: " + fromAccount.getBalance());
		}

		fromAccount.setBalance(fromAccount.getBalance() - transaction.getBalance());
		toAccount.setBalance(toAccount.getBalance() + transaction.getBalance());

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		return transactionRepository.save(transaction);
	}

}
