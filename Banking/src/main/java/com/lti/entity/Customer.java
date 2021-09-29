package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="proj_customer")
public class Customer {
	
	@Id
	@GeneratedValue
	int customerId;
	
	String firstName;
	String middleName;
	String lastName;
	String mobile;
	String email;
	String aadharNo;
	LocalDate dateOfBirth;
	String panCard;
	String password;
	String occupationType;
	double annualIncome;
	//status
	
	@OneToOne(mappedBy="customer",cascade =CascadeType.ALL)
	Address address;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	List<Account> account;
	
	
	
	

	public Customer() {
		super();
	}
	

	public Customer(int customerId, String firstName, String middleName, String lastName, String mobile, String email,
			String aadharNo, LocalDate dateOfBirth, String panCard, String password, String occupationType,
			int annualIncome) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.aadharNo = aadharNo;
		this.dateOfBirth = dateOfBirth;
		this.panCard = panCard;
		this.password = password;
		this.occupationType = occupationType;
		this.annualIncome = annualIncome;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double d) {
		this.annualIncome = d;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Account> getAccount() {
		return account;
	}


	public void setAccount(List<Account> account) {
		this.account = account;
	}


	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", mobile=" + mobile + ", email=" + email + ", aadharNo=" + aadharNo
				+ ", dateOfBirth=" + dateOfBirth + ", panCard=" + panCard + ", password=" + password
				+ ", occupationType=" + occupationType + ", annualIncome=" + annualIncome + ", address=" + address
				+ "]";
	}
	

}
