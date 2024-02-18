package com.example.demo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.database.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
