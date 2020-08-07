package com.anz.account.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.account.data.AccountEntity;
import com.anz.account.data.AccountsRepository;
import com.anz.account.shared.AccountsDto;

@Service
public class AccountsServiceImpl implements AccountsService{

	@Autowired
	AccountsRepository accountRepository;
	
	public AccountsDto getAccountByAccountId(String accountNumber) {
		
		AccountEntity accountsEntity = accountRepository.findByAccountNumber(accountNumber);
		
		AccountsDto accountsDto = new ModelMapper().map(accountsEntity, AccountsDto.class);
		
		
		return accountsDto;
	}

	public List<AccountsDto> getAllAccounts() {
		List<AccountEntity> accountsEntities = accountRepository.findAll();
		
		List<AccountsDto> accountsDtoList = accountsEntities.stream().map(entity -> new ModelMapper().map(entity, AccountsDto.class)).collect(Collectors.toList());
		
		return accountsDtoList;
	}

	@Override
	public AccountsDto createAccount(AccountsDto accountDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		accountDetails.setBalanceDate(new Date());
		
		AccountEntity accountEntity = modelMapper.map(accountDetails, AccountEntity.class);
		
		accountRepository.save(accountEntity);
		
		return accountDetails;
	}

	@Override
	public AccountsDto updateAccount(AccountsDto accountDetails) {
		AccountEntity accountsEntity = accountRepository.findByAccountNumber(accountDetails.getAccountName());
		accountsEntity.setAccountBalance(accountDetails.getAccountBalance());;
		
		accountRepository.save(accountsEntity);
		return accountDetails;
	}

}
