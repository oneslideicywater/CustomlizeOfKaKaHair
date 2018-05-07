package com.oneslide.RestfulCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneslide.RestfulCheck.entity.Customer;

/**一些数据库测试数据*/

@Service
public class PopulateCustomer {
   
	 @Autowired
	 CustomerService customService;
     
	 char[] alphabet= {'a','b','c','d','e','h','i',
			           'j','k','l','m','t','z','u',
			           '-','+','1','2','3','4','5',
			           '6','7','8','9','0',
     };
	
	 /**用工具函数可以生成很好的用户模拟数据*/
	 
	 public void populate() {
		 Customer customer;
	     for(int i=0;i<5;i++) {
	    	 customer=new Customer();
	    	 customer.setAge(this.generateValid(10, 80));
	    	 customer.setStature(this.generateValidDouble(0.8, 2.5));
	    	 customer.setWeight(this.generateValidDouble(20, 200));
	    	 
	    	 this.getCustomService().saveCustomer(customer);
	     } 
		 
	 }
	 
	 /*生成指定长度随机字符串*/
	 public String randomStringFactory(int length) {
		 String generator="";
		 for(int i=0;i<length;i++) {
			 int p=(int) (Math.random()*26);
			 generator=generator+alphabet[p];
		 }
		 
		 return generator;
	 }
	 
	 public int generateValid(int start,int end) {
		 
		   int generator=0;
		   while(generator<start) {
			   generator=(int) (Math.random()*end);
		   }
		   return generator;
	 }
	 
	 public double generateValidDouble(double start,double end) {
		 
		   double generator=0.00;
		   while(generator<start) {
			   generator=Math.random()*end;
		   }
		   return generator;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public CustomerService getCustomService() {
		return customService;
	}

	public void setCustomService(CustomerService customService) {
		this.customService = customService;
	}
	 
	 
	 
}
