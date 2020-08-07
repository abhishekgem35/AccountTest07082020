package com.anz.account.ui.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.exception.AccountServiceException;
import com.anz.account.service.AccountsService;
import com.anz.account.service.TransactionService;
import com.anz.account.shared.AccountsDto;
import com.anz.account.shared.TransactionDto;
import com.anz.account.ui.model.AccountResponseModel;
import com.anz.account.ui.model.CreateAccountRequestModel;
import com.anz.account.ui.model.CreateAccountResponseModel;
import com.anz.account.ui.model.TransactionRequestModel;
import com.anz.account.ui.model.TransactionResponseModel;


@RestController
@RequestMapping("/")
public class AccountController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	AccountsService accountsService;	
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<CreateAccountResponseModel> createAccount(@RequestBody CreateAccountRequestModel accountDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AccountsDto accountsDto = new ModelMapper().map(accountDetails, AccountsDto.class);
		AccountsDto createdAccount = accountsService.createAccount(accountsDto);
		
		
		CreateAccountResponseModel returnValue = modelMapper.map(createdAccount, CreateAccountResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@PutMapping
	public ResponseEntity<TransactionResponseModel> updateAccount(@RequestBody TransactionRequestModel transactionDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		TransactionDto transactionDto = new ModelMapper().map(transactionDetails, TransactionDto.class);
		
		TransactionDto createdTransaction = transactionService.createTransaction(transactionDto);
		
		TransactionResponseModel returnValue = modelMapper.map(createdTransaction, TransactionResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	
	@GetMapping(value="/transactions/{accountNumber}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TransactionResponseModel>> getTransactions(@PathVariable("accountNumber") String accountNumber){
		
		if(accountNumber == null) {
			throw new AccountServiceException("Account Number is NULL");
		}
		
		List<TransactionDto> transactions = transactionService.getTransactionByAccountNumber(accountNumber);
		
		if(transactions == null) {
			throw new AccountServiceException("No Transaction found for account number " + accountNumber);
		}
		
		//AccountResponseModel returnValue = new ModelMapper().map(accountsDto, AccountResponseModel.class);
		List<TransactionResponseModel> returnValue = transactions.stream().map(transactionDto -> new ModelMapper().map(transactionDto, TransactionResponseModel.class)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	
	@GetMapping(value="/account/{accountNumber}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AccountResponseModel> getAccount(@PathVariable("accountNumber") String accountNumber){
		
		if(accountNumber == null) {
			throw new AccountServiceException("Account Number is NULL");
		}
		
		AccountsDto accountsDto = accountsService.getAccountByAccountId(accountNumber);
		
		if(accountsDto == null) {
			throw new AccountServiceException("Account Number Details not found");
		}
		
		AccountResponseModel returnValue = new ModelMapper().map(accountsDto, AccountResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@GetMapping(value="/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<AccountResponseModel>> geAllAccounts(){
		List<AccountsDto> accountsDtoList = accountsService.getAllAccounts();
		
		List<AccountResponseModel> returnValue = accountsDtoList.stream().map(accountsDto -> new ModelMapper().map(accountsDto, AccountResponseModel.class)).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
}
