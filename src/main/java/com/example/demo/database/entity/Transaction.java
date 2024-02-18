package com.example.demo.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer fromAccount;
	private Integer toAccount;
	private Double balance;

}
