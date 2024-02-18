package com.example.demo.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double balance;

}
