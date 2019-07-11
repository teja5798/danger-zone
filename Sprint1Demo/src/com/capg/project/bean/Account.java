package com.capg.project.bean;

public class Account {
	private String name;
	private long phoneNumber;
	private String emailId;
	private int balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailid() {
		return emailId;
	}
	public void setEmailid(String emailid) {
		this.emailId = emailid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
