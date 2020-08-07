package com.anz.account.shared;

import java.io.Serializable;
import java.util.Date;

public class AccountsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6394185042361851743L;
	
	private String accountNumber;
	private String accountName;
	private String accountType;
	private Date balanceDate;
	private String currency;
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
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
