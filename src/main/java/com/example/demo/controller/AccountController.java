package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.entity.Account;
import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@PostMapping("/accounts")
	public ResponseEntity<Account> addNewAccount(@RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addNewAccount(account));
	}

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> showAllAccounts() {
		return ResponseEntity.ok(accountService.showAllAccounts());
	}

//	@DeleteMapping("/accounts")
//	public void deleteAllAccounts() {
//		accountService.deleteAllAccounts();
//	}

	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> showAccountById(@PathVariable Integer id) {
		return ResponseEntity.ok(accountService.showAccountById(id));
	}

	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<Account> deleteAccountById(@PathVariable Integer id) {
		return ResponseEntity.ok(accountService.deleteAccountById(id));
	}

	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> fullUpdateAccountById(@PathVariable Integer id, @RequestBody Account account) {
		account.setId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.fullUpdateAccountById(id, account));
	}

	@PatchMapping("/accounts/{id}")
	public ResponseEntity<Account> partialUpdateAccountById(@PathVariable Integer id, @RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(accountService.partialUpdateAccountById(id, account));
	}

}
