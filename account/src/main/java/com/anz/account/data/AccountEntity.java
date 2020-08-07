package com.anz.account.data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

// Table and Column for the RDBMS 

@Entity
@Document(collection="accounts")
public class AccountEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731425678149216053L;
	
	@Id
	@GeneratedValue
	private BigInteger id;
	
	@Indexed(unique = true)
	private String accountNumber;
		
	private String accountName;
	
	private String accountType;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date balanceDate;
	
	private String currency;
	
	private Double accountBalance;
	
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
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
