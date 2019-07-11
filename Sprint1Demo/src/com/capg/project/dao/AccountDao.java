package com.capg.project.dao;

import java.util.HashMap;

import com.capg.project.bean.Account;
import com.capg.project.exceptions.AccountNotFoundException;
import com.capg.project.exceptions.InsuffecientBalanceException;

public interface AccountDao {
	public void createAccountDao(String AccountNumber, Account user);
	public Account viewAccount(String AccountNumber) throws AccountNotFoundException;
	public void addMoney(String AccountNumber, int Amount) throws AccountNotFoundException;
	public void transfer(String AccNumber1,String AccNumber2, int Amount) throws InsuffecientBalanceException,AccountNotFoundException;
	public void validateAccount(String accountNumber) throws AccountNotFoundException;
	public void checkSuffecientBalance(String accNumber1, int amount) throws InsuffecientBalanceException;
	public HashMap<String, Account> getAllAccounts();
	

}
