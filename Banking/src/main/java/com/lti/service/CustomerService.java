package com.lti.service;

import com.lti.entity.Address;
import com.lti.entity.Customer;

public interface CustomerService {
	public Customer addOrUpdateACustomer(Customer customer);

	public Customer addorUpdateCustomerWithAnAddress(Customer customer);

	public Address addAddressToACustomer(Address address);

	public Address getCustomerAddressByCustomerId(int customerId);

	public Customer findCustomerById(int customerId);
	

}
