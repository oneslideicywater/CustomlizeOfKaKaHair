package com.oneslide.RestfulCheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneslide.RestfulCheck.Input.CustomerForm;
import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.service.CustomerService;
import com.oneslide.RestfulCheck.service.ProfileService;

@Controller
public class CustomerFormController {
      
	  @Autowired 
	  CustomerService customerService;
	  
	  @Autowired
	  ProfileService profileService;
	  //这个是处理用户输入表单的控制器
	
	  @RequestMapping(path="/customize")
	  public String showform() {
		  
		  return "intex";
	  }
	  //展示用户报告,前端进入口
	  
	  
	  /*
	   * @StateImport of Customize
	   * */
	  @RequestMapping(path="/customize/report",consumes="application/json")
	  public String report(CustomerForm forminput,Model model) {
		  Customer cus=Customer.transformIntoCustomer(forminput);
		  long id=customerService.saveCustomer(cus);
		  model.addAttribute("depict",forminput.getDescription());
		  return "report:/customer/"+id+"/report";
	  }
	  
	  
	  //测试入口
	  @RequestMapping(path="/test")
	  public String showtest() {
		  
		  return "test";
	  }
	  
}
