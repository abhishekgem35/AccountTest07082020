package com.anz.account.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponseModel {
	
	private String accountNumber;
	private String accountName;
	private Date transactionDate;
	private String transactionType;
	private String currency;	
	private String transactionAmount;	

}
