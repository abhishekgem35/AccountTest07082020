package com.anz.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anz.account.data.AccountsRepository;

@SpringBootApplication
public class AccountApplication {

	@Autowired
	AccountsRepository accountsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
}
