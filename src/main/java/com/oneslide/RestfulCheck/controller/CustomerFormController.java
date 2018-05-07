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
	  
	  @RequestMapping(path="/customize")
	  public String showform() {
		  
		  return "consult";
	  }
	  //展示用户报告,前端进入口
	  
	  
	  /*
	   * @StateImport of Customize
	   * 
	   * consult.html want to send to report.html
	   * */
	  @RequestMapping(path="/customize/report",consumes="application/json")
	  public void TurnReport(HttpServletResponse response,@RequestBody @Valid CustomerForm formInput,HttpSession session) {
		  
		 // redirectAttribute.addFlashAttribute("input",formInput); 
		  session.setAttribute("input", formInput);
		  try {
			response.sendRedirect("/customize/report/data");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //测试之后，改为report
		  
	  }
	  /**
	  @RequestMapping(path="/customize/report/datatest",produces="application/json")
	  public CustomerForm reporttest(HttpSession session) {
		  System.out.println("/customize/report/data have been located");
		  //获取用户提交表单信息
		 // CustomerForm form=(CustomerForm)redirectAttribute.getFlashAttributes().get("input");
		   CustomerForm form;
		   form=(CustomerForm)session.getAttribute("input");
					  System.out.println("form="+form);
	     return form;
	  }
	  
	  **/
	  @RequestMapping(path="/customize/report/data",produces="application/json")
	  public Report report(HttpSession session) {
		  System.out.println("/customize/report/data have been located");
		  //获取用户提交表单信息
		   CustomerForm form;
		   form=(CustomerForm)session.getAttribute("input");
		   System.out.println("form="+form);
					
		  
		 //将存储在Session中的用户ID取出，根据ID取出用户头像
		 long id=1; //虚拟ID，id在静默登陆时存入
		 
		 
		 //通过ID计算BMI
		double bmi=analysisService.calculateBMI(id);
			
		String advice=analysisService.BMIAdvice(bmi);
		Report report=analysisService.reportStatic(form);
		report.setAdvice(advice);
		report.setBMI(bmi);
		report.setAge(form.getAge()+"岁");
        report.setStature(form.getStature()*100+"cm");
        report.setWeight(form.getWeight()+"kg");
		//计算推荐发型
		List<Profile> profilelist=profileService.select(form.getGender(),form.getFavorStyle(), form.getFeature());
		
		List<String> listHairCut=new ArrayList<String>();
		for(int i=0;i<profilelist.size();i++) {
			listHairCut.add(profilelist.get(i).getImage());
		}
		report.setHaircutURL(listHairCut);
		
		return report;
	  }
	  
	  
	  @RequestMapping(path="/sessiontest")
	  public String sessionTest(HttpSession session) {
		  long id=(long)session.getAttribute("id");
		  System.out.println("============id========="+id);
		  return "test";
	  }
	  
	  //测试入口
	  @RequestMapping(path="/test")
	  public void showtest(HttpSession session,HttpServletResponse response) {
		  session.setAttribute("id", new Long(11));
		  try {
			  //跳转到外网地址成功，那么我可以在微信公众号的按钮中填入自己的域名了
			response.sendRedirect("http://www.baidu.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	  }
	  
}
