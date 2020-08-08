package com.anz.account.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.account.data.AccountsRepository;
import com.anz.account.data.TransactionEntity;
import com.anz.account.data.TransactionRepository;
import com.anz.account.shared.TransactionDto;


@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	AccountsRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<TransactionDto> getTransactionByAccountNumber(String accountNumber) {

		log.info("inside TransactionServiceImpl.getTransactionByAccountNumber()");
		List<TransactionEntity> entities = transactionRepository.findByAccountNumber(accountNumber);
		
		
		List<TransactionDto> transactionDtoList = entities.stream().map(entity -> new ModelMapper().map(entity, TransactionDto.class)).collect(Collectors.toList());
		
		return transactionDtoList;
	}

	@Override
	public TransactionDto createTransaction(TransactionDto transactionDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		transactionDetails.setTransactionDate(new Date());
		
		TransactionEntity transactionEntity = modelMapper.map(transactionDetails, TransactionEntity.class);
		
		transactionRepository.save(transactionEntity);
		
		return transactionDetails;
	}

}
