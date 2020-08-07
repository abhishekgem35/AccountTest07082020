package com.anz.account.shared;

import java.io.Serializable;
import java.util.Date;

public class TransactionDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6394185042361851743L;
	
	private String accountNumber;
	private String accountName;
	private Date transactionDate;
	private String currency;
	private String transactionType;
	private Double transactionAmount;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
}
