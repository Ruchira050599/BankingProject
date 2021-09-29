package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="proj_acc")
public class Account {
	@Id
	@SequenceGenerator(name="acc_seq",initialValue=10000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="acc_seq")
	int accountNo;
	
	int balance;
	AccountType accountType;
	ApprovalStatus status;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer;
	
	@OneToMany(mappedBy="account",cascade =CascadeType.ALL)
	List<Transaction> transaction;
	
	@OneToOne(mappedBy="account",cascade =CascadeType.ALL)
	Register register;

	@OneToMany(mappedBy="account",cascade=CascadeType.ALL)
	List<Beneficiary> beneficiary;
	
	public Account() {
		super();
	}

	public Account(int accountNo, int balance, AccountType accountType, ApprovalStatus status) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.accountType = accountType;
		this.status = status;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public ApprovalStatus getStatus() {
		return status;
	}

	public void setStatus(ApprovalStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	
	public List<Beneficiary> getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(List<Beneficiary> beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + ", accountType=" + accountType + ", status="
				+ status + "]";
	}
	
	
	
}
