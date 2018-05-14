package com.oneslide.RestfulCheck.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oneslide.RestfulCheck.Input.CustomerForm;
import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.output.Report;
import com.oneslide.RestfulCheck.service.AnalysisService;
import com.oneslide.RestfulCheck.service.CustomerService;
import com.oneslide.RestfulCheck.service.ProfileService;


//RESTful注解能够省很多麻烦
@Controller

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
    
    @RequestMapping(path="/customize")
	  public String showform() {
		  
		  return "consult";
	  }
    
    
	
	/*跳转到report*/
	  @RequestMapping(path="/customize/report",consumes="application/json")
	  public String TurnReport(HttpServletResponse response,@RequestBody @Valid CustomerForm formInput,HttpSession session) {
		  
		 // redirectAttribute.addFlashAttribute("input",formInput); 
		  session.setAttribute("input", formInput);
		  System.out.println(formInput);
		  return "redirect:/customize/showreport";
		   
	  }
	  @ResponseStatus(HttpStatus.OK)
	  @RequestMapping(path="/customize/showreport")
	  public ResponseEntity<?> TurntoReport() {
		  
		   return ResponseEntity.ok("report success");
		   
	  }
	  @ResponseStatus(HttpStatus.OK)
	  @RequestMapping(path="/customize/reportshow")
	  public String TurntoReport2() {
		  
		   return "report";
		   
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
