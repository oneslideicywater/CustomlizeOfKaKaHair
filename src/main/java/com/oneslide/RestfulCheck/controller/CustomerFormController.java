package com.oneslide.RestfulCheck.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oneslide.RestfulCheck.Input.CustomerForm;
import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.entity.Profile;
import com.oneslide.RestfulCheck.output.Report;
import com.oneslide.RestfulCheck.service.AnalysisService;
import com.oneslide.RestfulCheck.service.CustomerService;
import com.oneslide.RestfulCheck.service.ProfileService;



@RestController
public class CustomerFormController {
      
	  @Autowired 
	  CustomerService customerService;
	  
	  @Autowired
	  ProfileService profileService;
	  //这个是处理用户输入表单的控制器
	
	  @Autowired
	  AnalysisService analysisService;
	  
	
	  //展示用户报告,前端进入口
	  @RequestMapping(path="/customize/report/data",produces="application/json")
	  public Report report(HttpSession session) {
		
		  //获取用户提交表单信息
		   CustomerForm form;
		   form=(CustomerForm)session.getAttribute("input");
		   System.out.println("form="+form);
					
		  
		 //将存储在Session中的用户ID取出，根据ID取出用户头像
	 
		 long id=(long)session.getAttribute("id"); //虚拟ID，id在静默登陆时存入
		 if(id<1) {
			 return null;
		 }
		 
		 //将用户输入的数据转入数据库
		 Customer cus=customerService.getCustomer(id);
		 cus=form.convertToCustomer(cus);
		 customerService.saveCustomer(cus);
		 
		 
		 //通过ID计算BMI
		double bmi=analysisService.calculateBMI(id);
			
		String advice=analysisService.BMIAdvice(bmi);
		Report report=analysisService.reportStatic(form);
		report.setAdvice(advice);
		report.setBMI(bmi);
		report.setAge(form.getAge()+"岁");
        report.setStature(form.getStature()+"cm");
        report.setWeight(form.getWeight()+"kg");
		//计算推荐发型
		List<Profile> profilelist=profileService.select(form.getGender(),form.getFavorStyle(), form.getFeature());
		
		List<String> listHairCut=new ArrayList<String>();
		for(int i=0;i<profilelist.size();i++) {
			listHairCut.add("/src/main/resources/templates/imgDB/"+profilelist.get(i).getId());
		}
		report.setHaircutURL(listHairCut);
		
		return report;
	  }
	  
	  

	  
}
