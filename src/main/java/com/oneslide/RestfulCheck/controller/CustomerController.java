package com.oneslide.RestfulCheck.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneslide.RestfulCheck.Input.CustomerForm;
import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.output.Report;
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
	
	
	@RequestMapping(path="/customer/{id}/advice",produces="application/json")
	public Report returnadvice(@PathVariable("id") long id,Model model) {
		
		double bmi=analysisService.calculateBMI(id);
		
		String advice=analysisService.BMIAdvice(bmi);
		Report report=new Report();
		report.setAdvice(advice);
		report.setBMI(bmi);
		return report;
	}
	
    /**
     * JSON test
     * */
	@RequestMapping(path="/customer/{id}/report",produces="application/json",consumes="application/json")
	public Report advice(@PathVariable("id") long id,@RequestBody CustomerForm input) {
		
		double bmi=analysisService.calculateBMI(id);
		
		String advice=analysisService.BMIAdvice(bmi);
		Report report=analysisService.reportStatic(input);
		report.setAdvice(advice);
		report.setBMI(bmi);
		return report;
	}
	
	/*
	 * 测试Controller,测试点，正确获取表单信息
	 * 
	 * 
	 * **/
	@RequestMapping(path="/customer/inputTest",produces="application/json",consumes="application/json")
	public CustomerForm adviceTest(@RequestBody CustomerForm input) {
		
	
		return input;
	}
	
	
	/**
	 * @StateImport
	 *   
	 *     BMI 
	 * @StateExport 
	 * **/
	@RequestMapping(value="/customer/{id}/bmi",produces="application/json")
	public double getCustomer(@PathVariable("id") long id,Model model) {
		//commit reset point 1
	 
		double cus=analysisService.calculateBMI(id);
	    return cus;
	}
	
	
	
	
	
	
}
