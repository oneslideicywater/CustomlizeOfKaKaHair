package com.oneslide.RestfulCheck.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.service.AnalysisService;
import com.oneslide.RestfulCheck.service.CustomerService;
import com.oneslide.RestfulCheck.service.ProfileService;


//RESTful注解能够省很多麻烦
@RestController

public class CustomerController {
	public CustomerController(CustomerService customerService, AnalysisService analysisService) {
		super();
		this.customerService = customerService;
		this.analysisService = analysisService;
		
		
	}
	@Autowired
    CustomerService customerService;
    @Autowired
    AnalysisService analysisService;
    
    

   //save the customer 
	@PostMapping(path="/customer",consumes="application/json")
	public String recordCustomer(Customer customer) {
		customerService.saveCustomer(customer);
		return "Customer saved";
	}
	
	/**
	 * @StateImport
	 *     CustomerInformation
	 * @StateExport
	 * 
	 * **/
	
	
	@RequestMapping(path="/customer/{id}",produces="application/json")
	public Customer returnIdKnownCustomer(@PathVariable("id") long id,Model model) {
		Customer customer=customerService.getCustomer(id);
		return customer;
	}
	

	
	
	
	
	/**
	 * @StateImport
	 *   
	 *     BMI 
	 * @StateExport 
	 * **/
	@RequestMapping(value="/customize/{id}/bmi",produces="application/json")
	public double getCustomer(@PathVariable("id") long id,Model model) {
		//commit reset point 1
	 
		double cus=analysisService.calculateBMI(id);
	    return cus;
	}
	
	@RequestMapping(value="/generate",produces="application/json")
	public List<Customer> genCustomer() {
		//commit reset point 1
		
		for(int i=0;i<100;i++) {
			Customer cus=new Customer();
		    cus.setFeature("round face");
			
			cus.setGender(false);
			cus.setTelephone(123456789);
			cus.setWeight(90.32);
			customerService.saveCustomer(cus);
		}
		
	    return customerService.allcustomer();
	}
	
	
}
