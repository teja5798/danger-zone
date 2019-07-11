package com.capg.project.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.project.bean.Account;
import com.capg.project.exceptions.*;
public class Validator {
	boolean result=false;
	boolean result1=false;
	boolean result2=false;
	public void validator(Account user) throws InvalidMailException,InvalidPhoneNumberException
	{
		try {
			validatePhoneNumber(user.getPhoneNumber());
			validateEmail(user.getEmailid());
			
		} catch (InvalidPhoneNumberException | InvalidMailException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	public void validateEmail(String string) throws InvalidMailException
	{
		try
		{
			Pattern p = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b");
			Matcher m = p.matcher(string);
			if(!m.matches())
			{
				throw new InvalidMailException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void validatePhoneNumber(long phone) throws InvalidPhoneNumberException
	{
		try
		{
			String temp=String.valueOf(phone);
			Pattern p = Pattern.compile("\\d{10}");
			Matcher m = p.matcher(temp);
			if(!m.matches() || (!(temp.length()==10)))
			{
				throw new InvalidPhoneNumberException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
}
