package com.lti.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CustomerDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusType;
import com.lti.entity.Account;
import com.lti.entity.Address;
import com.lti.entity.Customer;
import com.lti.service.AccountService;
import com.lti.service.CustomerService;



@RestController
@CrossOrigin
public class BankController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
//	@PostMapping("/addOrUpdateACustomer")
//	//http://localhost:8585/addOrUpdateACustomer
//	public Customer addorUpdateCustomer(@RequestBody CustomerDto customerDto) {
//		Customer c = new Customer();
//		c.setFirstName(customerDto.getFirstName());
//		c.setMiddleName(customerDto.getMiddleName());
//		c.setLastName(customerDto.getLastName());
//		c.setMobile(customerDto.getMobile());
//		c.setEmail(customerDto.getEmail());
//		c.setAadharNo(customerDto.getAadharNo());
//		c.setDateOfBirth(LocalDate.parse(customerDto.getDateOfBirth()));
//		c.setPanCard(customerDto.getPanCard());
//		c.setPassword(customerDto.getPassword());
//		c.setOccupationType(customerDto.getOccupationType());
//		c.setAnnualIncome(customerDto.getAnnualIncome());
//		//c.setCustomerId(7);//will update the customer
//		return customerService.addOrUpdateACustomer(c);
//	}
	@PostMapping("/addOrUpdateACustomer")
	//http://localhost:8585/addOrUpdateACustomer
	public Status addorUpdateCustomer(@RequestBody CustomerDto customerDto) {
		 try {
			 Customer customer=new Customer();
		        customer.setFirstName(customerDto.getFirstName());
		        customer.setMiddleName(customerDto.getMiddleName());
		        customer.setLastName(customerDto.getLastName());
		        customer.setMobile(customerDto.getMobile());
		        customer.setEmail(customerDto.getEmail());
		        customer.setAadharNo(customerDto.getAadharNo());
		        customer.setDateOfBirth(LocalDate.parse(customerDto.getDateOfBirth()));
		        customer.setPanCard(customerDto.getPanCard());
		        customer.setPassword(customerDto.getPassword());
		        customer.setOccupationType(customerDto.getOccupationType());
		        customer.setAnnualIncome(customerDto.getAnnualIncome());
             customerService.addOrUpdateACustomer(customer);
            
             Status status = new Status();
             status.setStatus(StatusType.SUCCESS);
             status.setMessage("Registration successful!");
             return status;
         }
         catch(Exception e) {
             Status status = new Status();
             status.setStatus(StatusType.FAILURE);
             status.setMessage(e.getMessage());
             return status;
         }
	}
	
//	@PostMapping("/addOrUpdateACustomer")
//	//http://localhost:8585/addOrUpdateACustomer
//	public Status addorUpdateCustomer(@RequestBody Customer customer) {
//		 try {
//             customerService.addOrUpdateACustomer(customer);
//            
//             Status status = new Status();
//             status.setStatus(StatusType.SUCCESS);
//             status.setMessage("Registration successful!");
//             return status;
//         }
//         catch(Exception e) {
//             Status status = new Status();
//             status.setStatus(StatusType.FAILURE);
//             status.setMessage(e.getMessage());
//             return status;
//         }
//	}
	
	
	@PostMapping("/addAddressToACustomer/{customerId}")
	//http://localhost:8585/addAddressToACustomer/55
	//http://localhost:8585/BankREst/rest/bank/addAddressToACustomer/7
	public void addAddressToACustomer(@PathVariable int customerId, @RequestBody Address address) {
		Customer c = customerService.findCustomerById(customerId);
		if(c.getAddress() == null) {
			Address add = new Address();
			//add.setAddressId(104);//will update the address
			add.setAddress(address.getAddress());
			add.setLandmark(address.getLandmark());
			add.setCity(address.getCity());
			add.setState(address.getState());
			add.setPincode(address.getPincode());
			add.setCustomer(c);
			customerService.addAddressToACustomer(add);
		}
		else {
			System.out.println("Address exists for customer");
		}	
	}
	

	//@GetMapping(value= "/customerAddress/{customerId}")
	@RequestMapping(value = "/customerAddress/{customerId}", method= RequestMethod.GET)
	//http://localhost:8585/customerAddress
	//http://localhost:8585/BankREst/rest/bank/customerAddress/6
	public Address getCustomerAddressByCustomerId(@PathVariable int customerId) {
			return customerService.getCustomerAddressByCustomerId(customerId);
	}
	
	@PostMapping("/addAccountToACustomer/{customerId}")
	//http://localhost:8585/addAccountToACustomer/55
	//http://localhost:8585/BankREst/rest/bank/addAccountToACustomer/55
	public void addAccountToACustomer(@PathVariable int customerId, @RequestBody Account account) {  
		Customer c = customerService.findCustomerById(customerId);
		//check if address is present 
		//findAddressByCustomerId
		Account a= new Account();
		a.setStatus(account.getStatus());
		a.setBalance(account.getBalance());
		a.setAccountType(account.getAccountType());
		a.setCustomer(c);
		accountService.addAccountWithAnExistingCustomer(a, c);
	}
	
	
}
