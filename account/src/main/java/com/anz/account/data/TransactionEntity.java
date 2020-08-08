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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
