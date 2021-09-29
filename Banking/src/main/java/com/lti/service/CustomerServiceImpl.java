package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.CustomerDao;
import com.lti.entity.Address;
import com.lti.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer addOrUpdateACustomer(Customer customer) {
		
		return  customerDao.addOrUpdateACustomer(customer);
	}
	@Override
	public Customer addorUpdateCustomerWithAnAddress(Customer customer) {
		
		return customerDao.addorUpdateCustomerWithAnAddress(customer);
	}

	@Override
	public Address addAddressToACustomer(Address address) {
		
		return customerDao.addAddressToACustomer(address);
	}

	@Override
	public Address getCustomerAddressByCustomerId(int customerId) {
		
		return customerDao.getCustomerAddressByCustomerId(customerId);
	}

	@Override
	public Customer findCustomerById(int customerId) {
		
		return customerDao.findCustomerById(customerId);
	}



}
