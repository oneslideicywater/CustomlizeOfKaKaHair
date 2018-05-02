package com.oneslide.RestfulCheck.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.activation.FileTypeMap;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oneslide.RestfulCheck.entity.Customer;
import com.oneslide.RestfulCheck.entity.Profile;
import com.oneslide.RestfulCheck.service.CustomerService;
import com.oneslide.RestfulCheck.service.ProfileService;

@RestController
public class FilterController { 
	
   @Autowired
   CustomerService customerService;
   @Autowired
   ProfileService profileService;
	
   /*
    *   @StateExport of Customize
    * **/
   
  @RequestMapping(path="/customer/{id}/report",produces="application/json")
	public List<Profile> recordCustomer(@PathVariable("id") long id,@RequestParam("depict") String depict,Model model) {
		Customer customer=customerService.getCustomer(id);
		if(customer==null) {
			//页面跳转
			return null;
		}
		List<Profile> list=profileService.select(customer,depict);
		return list;
	}
	
	@RequestMapping(path="/report",produces="application/json")
	public List<Profile> recordCustomer() {
		
		return profileService.all();
	}
	
	
	//暴露文件为一个URL地址
	
	@GetMapping("/report/img/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") long id) throws IOException{
		
		Profile profile=profileService.findProfileById(id);
		String pathOfImg=profile.getImage();
	    File img = new File(pathOfImg);
	    return ResponseEntity
	    		.ok()
	    		.contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
	    		.body(Files.readAllBytes(img.toPath()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
