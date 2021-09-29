package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Address;
import com.lti.entity.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Customer addOrUpdateACustomer(Customer customer) {
		Customer persistedUser = em.merge(customer);
		return persistedUser;
	}


	@Override
	@Transactional
	public Customer addorUpdateCustomerWithAnAddress(Customer customer) {
		Customer c = em.merge(customer);
	    return c;
	}

	@Override
	@Transactional
	public Address addAddressToACustomer(Address address) {
		Address add = em.merge(address);
		return add;
	}

	@Override
	public Address getCustomerAddressByCustomerId(int customerId) {

		Customer u = em.find(Customer.class, customerId);
		return u.getAddress();
	}

	@Override
	public Customer findCustomerById(int customerId) {
		Customer c = em.find(Customer.class, customerId);
		return c;
	}


}
