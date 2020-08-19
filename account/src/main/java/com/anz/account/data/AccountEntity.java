package com.anz.account.data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Table and Column for the RDBMS 

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
