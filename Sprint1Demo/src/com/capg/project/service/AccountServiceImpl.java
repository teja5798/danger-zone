package com.capg.project.service;

import java.util.HashMap;
import java.util.Random;

import com.capg.project.bean.Account;
import com.capg.project.dao.*;
import com.capg.project.exceptions.*;
public class AccountServiceImpl extends Validator implements AccountService{
	AccountDao dao=new AccountDaoImpl();
	Validator v=new Validator();
	@Override
	public String createAccountDao(Account user) throws  InvalidMailException, InvalidPhoneNumberException{
		// TODO Auto-generated method stub
		String AccountNumber=null;
		try 
		{
			v.validator(user);
			Random rand=new Random();
			int num=rand.nextInt(9000000)+1000000;
			 AccountNumber=String.valueOf(num);
			dao.createAccountDao(AccountNumber, user);
		}
		catch(Exception e)
		{
			throw e;
		}
		return AccountNumber;
		
	}


	@Override
	public Account viewAccount(String AccountNumber) throws AccountNotFoundException{

		try
		{
			return dao.viewAccount(AccountNumber);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public void addMoney(String AccountNumber, int Amount) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			dao.addMoney(AccountNumber, Amount);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public void transfer(String AccountNumber1, String AccountNumber2, int Amount) throws InsuffecientBalanceException,AccountNotFoundException {
		// TODO Auto-generated method stub
		try {
			dao.transfer(AccountNumber1, AccountNumber2, Amount);
			}
		catch(Exception e)
		{
			throw e;
		}
		
	}


	@Override
	public HashMap<String, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllAccounts();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
