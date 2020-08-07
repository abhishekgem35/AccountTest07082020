package com.anz.account.exception;

public class AccountServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7159797720879793339L;
	
	public AccountServiceException(String message) {
		super(message);
	}
}
