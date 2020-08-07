package com.anz.account.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountsRepository extends MongoRepository<AccountEntity, Long> {

	AccountEntity findByAccountNumber(String accountNumber);
	
}
