package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.database.entity.Account;
import com.example.demo.database.repository.AccountRepository;
import com.example.demo.service.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;

	// add
	public Account addNewAccount(Account account) {
		return accountRepository.save(account);
	}

	// show all
	public List<Account> showAllAccounts() {
		return accountRepository.findAll();
	}

//	// delete all
//	public List<Account> deleteAllAccounts() {
//		List<Account> accounts = accountRepository.findAll();
//		accountRepository.deleteAll();
//		return accountRepository.saveAll(accounts);
//	}

	// show by id
	public Account showAccountById(Integer id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Your Account: not found"));
	}

	// delete by id
	public Account deleteAccountById(Integer id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Your Account: not found"));
		accountRepository.deleteById(id);
		return accountRepository.save(account);
	}

	// full update by id
	public Account fullUpdateAccountById(Integer id, Account account) {
		accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Your Account: not found"));
		account.setId(id);
		return accountRepository.save(account);
	}

	// partial update by id
	public Account partialUpdateAccountById(Integer id, Account newAccount) {
		Account oldAcc = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Your Account: not found"));
		if (newAccount.getName() != null) {
			oldAcc.setName(newAccount.getName());
		}
		if (newAccount.getBalance() != null) {
			oldAcc.setBalance(newAccount.getBalance());
		}
		return accountRepository.save(oldAcc);
	}

}
