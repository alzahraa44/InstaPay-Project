package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.database.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
