package com.capg.project.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception{
	public AccountNotFoundException()
	{
		super("Check the Account Number you have Entered");
	}

}
