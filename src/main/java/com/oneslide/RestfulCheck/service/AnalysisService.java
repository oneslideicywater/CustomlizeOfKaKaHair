package com.oneslide.RestfulCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneslide.RestfulCheck.entity.Customer;





@Service
public class AnalysisService {
     public AnalysisService(CustomerService service) {
		super();
		this.service = service;
	}
	 
     @Autowired
     CustomerService service;
     
     public double calculateBMI(long id) {
    	 Customer customer=service.getCustomer(id);
    	 double bmi=customer.getWeight()/Math.pow(customer.getStature(),2);
    	 return bmi;
     }
     
     
}
