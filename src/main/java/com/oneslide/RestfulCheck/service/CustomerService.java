package com.oneslide.RestfulCheck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.repository.CustomerRepository;




@Service
public class CustomerService {
     
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Autowired
	CustomerRepository customerRepository;
	
	public long saveCustomer(Customer customer) {
		return customerRepository.save(customer).getId();
	 
	}
	public Customer getCustomer(long id) {
		Customer customer=customerRepository.findById(id);
		customer.setTelephone(0); //用户数据保护
		
		return customer;
	}
	
	public List<Customer> allcustomer() {
		
		List<Customer> list=customerRepository.findAll();
		return list;
	}
}
