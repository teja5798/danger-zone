package com.capg.project.dao;

import java.util.HashMap;
import java.util.Map;

import com.capg.project.bean.Account;
import com.capg.project.exceptions.*;

public class AccountDaoImpl implements AccountDao{
	Map<String, Account> userList=new HashMap<String, Account>();

	@Override
	public void createAccountDao(String accountNumber, Account user) 
	{
		try {
			userList.put(accountNumber, user);
		}
		catch(Exception e)
		{
			throw e;
		}
		}

	@Override
	public Account viewAccount(String accountNumber) throws AccountNotFoundException
	{
		try {
			validateAccount(accountNumber);
			Account user=new Account();
			user=userList.get(accountNumber);
			return user;
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void addMoney(String accountNumber, int amount) throws AccountNotFoundException
	{
	try {
			validateAccount(accountNumber);
			Account user=new Account();
			user=userList.get(accountNumber);
			int temp=user.getBalance();
			temp=temp+amount;
			user.setBalance(temp);
			
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public void transfer(String accNumber1, String accNumber2, int amount) throws InsuffecientBalanceException,AccountNotFoundException {
		try {
				validateAccount(accNumber1);
				validateAccount(accNumber2);
				checkSuffecientBalance(accNumber1, amount);
				Account user1=userList.get(accNumber1);
				Account user2=userList.get(accNumber2);
				int temp1=user1.getBalance();
				int temp2=user2.getBalance();
				temp1=temp1-amount;
				temp2=temp2+amount;
				user1.setBalance(temp1);
				user2.setBalance(temp2);
			}
			catch(Exception e)
			{
				throw e;
			}
		
	}
	@Override
	public void checkSuffecientBalance(String accNumber1, int amount) throws InsuffecientBalanceException {
		
		try {
			Account user=userList.get(accNumber1);
			if(user.getBalance()<amount)
			{
				throw new InsuffecientBalanceException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public void validateAccount(String accountNumber) throws AccountNotFoundException 
	{
	
		try
		{
			if(!userList.containsKey(accountNumber))
			{
				throw new AccountNotFoundException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public HashMap<String, Account> getAllAccounts() 
	{
try
		{
			return (HashMap<String, Account>) userList;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
