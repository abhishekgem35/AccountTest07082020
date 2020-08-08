package com.anz.account.shared;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
