package com.lti.repository;

import java.util.List;

import com.lti.entity.Account;
import com.lti.entity.Address;
import com.lti.entity.Customer;

public interface CustomerDao {
 
    //1st method
	public Customer addOrUpdateACustomer(Customer customer);
 
	//2nd method
	public Address addAddressToACustomer(Address address);

	//4th method
	public Address getCustomerAddressByCustomerId(int customerId);

	//3rd method
	public Customer findCustomerById(int customerId);

	
	
	public Customer addorUpdateCustomerWithAnAddress(Customer customer);

 
 
 
 // addOrUpdateAddress();
// viewCustomerDetails();
// findAById();
// 

// registerForNetBanking();
// loginACustomer();
// 
// forgetPassword();
// setPassword();
// 
// addABeneficiary();
 
}
