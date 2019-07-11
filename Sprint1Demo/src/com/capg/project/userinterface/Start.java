package com.capg.project.userinterface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.capg.project.bean.Account;
import com.capg.project.service.AccountServiceImpl;

import java.util.Scanner;
import java.util.Set;

public class Start {
	static AccountServiceImpl service=new AccountServiceImpl();
	public static void showMenu() 
	{
		System.out.println("01 ---> Create New Wallet ");
		System.out.println("02 ---> Recharge your Wallet");
		System.out.println("03 ---> Show Details of Wallet");
		System.out.println("04 ---> Transfer Money");
		System.out.println("05 ---> Show All Wallet Accounts");
		System.out.println("06 ---> Exit");
		System.out.print("Enter Your Choice : ");
	}
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true)
		{
			showMenu();
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("New Wallet Account Creation");
				System.out.println("---------------------------");
				
				try
				{
					Account user=new Account();
					System.out.println("Enter your Name:");
					user.setName(scanner.next());
					System.out.println("Enter your Phone Number:");
					user.setPhoneNumber(scanner.nextLong());
					System.out.println("Enter your E-mail:");
					user.setEmailid(scanner.next());
					user.setBalance(0);
					String AccountNumber=service.createAccountDao(user);
					System.out.println("Your Wallet Number is : "+AccountNumber);
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 2:
				System.out.println("Recharging Wallet");
				System.out.println("---------------------------");
				try {
					System.out.println("Enter the Wallet Number to be Recharged:");
					String AccountNumber=scanner.next();
					System.out.println("Enter the Amount to Recharge the Wallet"+AccountNumber);
					int Amount=scanner.nextInt();
					service.addMoney(AccountNumber, Amount);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("View Wallet Details");
				System.out.println("---------------------------");
				try
				{
					System.out.println("Enter the Wallet Number:");
					String AccountNumber=scanner.next();
					Account user=service.viewAccount(AccountNumber);
					System.out.println("Name:"+user.getName()+"\nPhone:"+user.getPhoneNumber()+"\nEmail:"+user.getEmailid()+"\nBalance:"+user.getBalance());
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("Money Transfer");
				System.out.println("---------------------------");
				try
				{
					System.out.println("Enter the Sender's Wallet Number:");
					String SenderAccountNumber=scanner.next();
					System.out.println("Enter the Reciever's Wallet Number:");
					String RecieverAccountNumber=scanner.next();
					System.out.println("Enter the Amount to be Transferred:");
					int TransferAmount=scanner.nextInt();
					service.transfer(SenderAccountNumber, RecieverAccountNumber, TransferAmount);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 5:
				try
				{
					Map<String, Account> userlist=new HashMap<String, Account>();
					userlist=service.getAllAccounts();
					if(!userlist.isEmpty())
					{

						Set<Entry<String, Account>> set=userlist.entrySet();
						Iterator<Entry<String, Account>> i=set.iterator();
						while(i.hasNext())
						{
							Map.Entry<String, Account> me=(Map.Entry<String, Account>)i.next();
							Account result=me.getValue();
							System.out.println("Wallet Number: "+me.getKey()+"\nName: "+result.getName());
						}
					}
					else
					{
						System.out.println("No Wallet Accounts Found");
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
			case 6:
				System.out.println("Thanks for using our Service");
				System.exit(0);
			default:
				System.out.println("No Such Services Found");
				break;
			}
		}
	}

}
