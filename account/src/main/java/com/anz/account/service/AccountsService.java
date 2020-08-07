package com.anz.account.service;

import java.util.List;

import com.anz.account.shared.AccountsDto;

public interface AccountsService {

	AccountsDto getAccountByAccountId(String accountId);
	
	List<AccountsDto> getAllAccounts();
	
	AccountsDto createAccount(AccountsDto accountDetails);
	
	AccountsDto updateAccount(AccountsDto accountDetails);
	
}
