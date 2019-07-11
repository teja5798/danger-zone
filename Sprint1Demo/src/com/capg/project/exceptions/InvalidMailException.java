package com.capg.project.exceptions;

@SuppressWarnings("serial")
public class InvalidMailException extends Exception {
	public InvalidMailException()
	{
		super("Check the Mail Id you have Entered");
	}

}
