package com.capg.project.exceptions;

@SuppressWarnings("serial")
public class InvalidPhoneNumberException extends Exception{
	public InvalidPhoneNumberException()
	{
		super("Check the Phone Number you have Entered");
	}

}
