package com.capg.project.exceptions;

@SuppressWarnings("serial")
public class InsuffecientBalanceException extends Exception
{
	public InsuffecientBalanceException() 
	{
		super("The Sender's Account Balance is insuffecient");
	}

}
