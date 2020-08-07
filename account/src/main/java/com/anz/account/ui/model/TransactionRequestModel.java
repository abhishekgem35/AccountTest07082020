package com.anz.account.ui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TransactionRequestModel {
	
	@NotNull(message="Account Number cannot be null")
	private String accountNumber;
	
	@NotNull(message="Account Name cannot be null")
	private String accountName;
	
	@NotNull(message="Transaction Type cannot be null")
	private String transactionType;
	
	@NotNull(message="Currency cannot be null")
	@Size(min=3,max=5, message="Currency must be min 3 characters and max 5 characters")
	private String currency;
	
	@NotNull(message="Account Balance cannot be null")
	private Double transactionAmount;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
