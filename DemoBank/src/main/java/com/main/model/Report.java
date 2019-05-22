package com.main.model;

import java.io.Serializable;

public class Report implements Serializable{

	private int user_id;
	private Double credits;
	private Double debits;
	private Double balance;
	private String month;
		
	public Report(int user_id, Double credits, Double debits, Double balance) {
		super();
		this.user_id = user_id;
		this.credits = credits;
		this.debits = debits;
		this.balance = balance;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Double getCredits() {
		return credits;
	}
	public void setCredits(Double credits) {
		this.credits = credits;
	}
	public Double getDebits() {
		return debits;
	}
	public void setDebits(Double debits) {
		this.debits = debits;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
