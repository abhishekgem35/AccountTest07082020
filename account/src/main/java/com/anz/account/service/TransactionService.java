package com.anz.account.service;

import java.util.List;

import com.anz.account.shared.TransactionDto;

public interface TransactionService {

	List<TransactionDto> getTransactionByAccountNumber(String accountId);
		
	TransactionDto createTransaction(TransactionDto transactionDetails);
	
}
