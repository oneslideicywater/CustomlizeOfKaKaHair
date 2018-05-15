package com.oneslide.RestfulCheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.repository.CustomerRepository;




@Service
public class CustomerService {
     
	public CustomerService() {
		super();
	}

    public CustomerService(CustomerRepository customerRepository) {
		
		this.customerRepository = customerRepository;
	}

	@Autowired
	CustomerRepository customerRepository;
	
	
	
	//数据库存储
	public long saveCustomer(Customer customer) {
		return customerRepository.save(customer).getId();
	 
	}
	
	
	//id查找用户
	
	public Customer getCustomer(long id) {
		Customer customer=customerRepository.findById(id);
		
		
		return customer;
	}
	
	//获取全部注册用户
	public List<Customer> allcustomer() {
		
		List<Customer> list=customerRepository.findAll();
		return list;
	}
	
	
}
