package com.anz.account.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionEntity, Long> {

	List<TransactionEntity> findByAccountNumber(String accountNumber);
	
}
