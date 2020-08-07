package com.anz.account.ui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateAccountRequestModel {
	
	@NotNull(message="Account Number cannot be null")
	private String accountNumber;
	
	@NotNull(message="Account Name cannot be null")
	private String accountName;
	
	@NotNull(message="Account Type cannot be null")
	private String accountType;
	
	@NotNull(message="Currency cannot be null")
	@Size(min=3,max=5, message="Currency must be min 3 characters and max 5 characters")
	private String currency;
	
	@NotNull(message="Account Balance cannot be null")
	private Double accountBalance;

	
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
