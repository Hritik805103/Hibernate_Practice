package com.app.entity;

public class BankAccount {

	private Integer id;
	private String AcHolderName;
	private Float balance;
	private Long AcNumber;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAcHolderName() {
		return AcHolderName;
	}
	public void setAcHolderName(String acHolderName) {
		AcHolderName = acHolderName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Long getAcNumber() {
		return AcNumber;
	}
	public void setAcNumber(Long acNumber) {
		AcNumber = acNumber;
	}
	
	
	
}
