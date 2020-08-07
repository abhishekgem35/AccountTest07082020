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

@Entity
@Document(collection="account_transactions")
public class TransactionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2731425678149216053L;
	
	@Id
	@GeneratedValue
	private BigInteger id;
	
	@Indexed(unique=false)
	private String accountNumber;
	
	private String accountName;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date transactionDate;
	
	private String currency;
	
	private Long transactionAmount;

	private String transactionType;

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
	public Long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
