package com.capg.project.service;

import java.util.HashMap;

import com.capg.project.bean.Account;
import com.capg.project.exceptions.*;

public interface AccountService {
	public String createAccountDao(Account user) throws InvalidMailException, InvalidPhoneNumberException;
	public Account viewAccount(String AccountNumber) throws AccountNotFoundException;
	public void addMoney(String AccountNumber, int Amount) throws AccountNotFoundException;
	public void transfer(String AccountNumber1,String AccountNumber2, int Amount) throws InsuffecientBalanceException, AccountNotFoundException;
	public HashMap<String, Account> getAllAccounts();
}
