package com.anz.account.ui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
