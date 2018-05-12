package com.oneslide.RestfulCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneslide.RestfulCheck.Input.CustomerForm;
import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.output.Report;





@Service
public class AnalysisService {
     public AnalysisService(CustomerService service) {
		super();
		this.service = service;
	}
	 
     @Autowired
     CustomerService service;
     
     public static String thin="你的BMI值处于偏瘦水平，适当调整下饮食结构，多 吃长肉，改善过于单薄的身材，才是注意的重点。"; 
     
     public static String medium="您的BMI值处在标准水平，请您继续保持良好的饮食习惯与生活作息，坚持好的生活习惯是受益终生的。";
     
     public static String fat="您的BMI值处在偏胖水平，请您提起注意，及时调整饮食习惯，多去运动运动，保持一个好的生活习惯，记住身体才是革命的本钱。";
    
     public static String overweight="您的BMI值处在肥胖水平。请您务必及时调整饮食习惯，每天保持一定运动量，坚持好的生活习惯，身体才是革命的本钱，保持健康身材，把体重降下来是您当前最紧要的事情！";


     /**
      * 计算BMI值
      * */
     public double calculateBMI(CustomerForm customer) {
    	 
    	 double bmi=customer.getWeight()/Math.pow(customer.getStature(),2);
    	 Double p=Double.parseDouble(String.format("%.2f", bmi));
    	 
    	 return p;
     }
     
     
     public double calculateBMI(long id) {
    	 
    	  Customer customer=service.getCustomer(id);
    	  double bmi= customer.getWeight()/Math.pow(customer.getStature(),2);
    	  Double p=Double.parseDouble(String.format("%.2f", bmi));
    	  return p;
     }
     
     /*
      * 根据BMI值来返回不同的建议
      * **/
     public String BMIAdvice(double BMI) {
    	 String advice="";
    	 if(BMI<=18.5) {
    		 advice=thin;
    	 }
    	 if(BMI>18.5&&BMI<=24) {
    		 advice=medium;
    	 }
    	 if(BMI>24&&BMI<=28) {
    		 advice=fat;
    	 }
    	 if(BMI>28) {
    		 advice=overweight;
    	 }
    	 return advice;
     }
     
     
     
     /**
      * @Param CustomerForm
      * CustomerForm:为用户输入的表单，
      * 根据用户输入的表单可以完全确定静态部分的图片连接，
      * 这部分图片连接完全存储在src/main/resources/static/img/report/文件夹下
      * 
      * @return Report
      * 
      * 返回一个用户报告
      * **/
     
     public Report reportStatic(CustomerForm input) {
    	  Report temp=new Report();
    	//  String root="/report/static/";
    	  //如果是女人
    	  if(!input.getGender()) {
    		  //女生脸型
    		 temp.setFeatureURL(this.AidReportStatic("fgirl",input.getFeature()));
    		 //女生体型
    		 temp.setSomatotypeURL(this.AidReportStatic("sgirl", input.getSomatotype()));
    		 //女生肤色
    		 temp.setComplexionURL(this.AidReportStatic("cgirl",input.getComplexion()));
    		 
    		
    	  }
    	  if(input.getGender()) {
    		 
    		  temp.setFeatureURL(this.AidReportStatic("fboy",input.getFeature()));
    		  temp.setSomatotypeURL(this.AidReportStatic("sboy", input.getSomatotype()));
    		  temp.setComplexionURL(this.AidReportStatic("cboy",input.getComplexion()));
    	  }
    	   String haircontent=input.getHairOilness()+""
    	                      +input.getHairToughness()+""
    			              +input.getHairVolume();
    	   temp.setHairMantainURL(this.AidReportStatic("hair",haircontent));
    	  return temp;
     }
     
     /**
      * 简化函数reportStatic的代码量，写的一个工具函数，
      * 返回一个组成字符串
      * **/
     
     private String AidReportStatic(String format,String content) {
    	 String root="/report/static/";
    	 return root+format+content+".jpg";
     }
     
     
     
     
     
     
     
}
