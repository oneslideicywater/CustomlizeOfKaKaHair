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
public class ResourceFilterController { 
	
   @Autowired
   CustomerService customerService;
   @Autowired
   ProfileService profileService;
	
   /*
    *   @StateExport of Customize
    *   
    *   @deprecated
    * **/
   
 
	
	@RequestMapping(path="/report",produces="application/json")
	public List<Profile> recordCustomer() {
		
		return profileService.all();
	}
	
	
	//暴露文件为一个URL地址
	
	@GetMapping("/src/main/resources/templates/imgDB/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") long id) throws IOException{
		
		Profile profile=profileService.findProfileById(id);
		if(profile==null) {
			 System.out.println("oneslide said:"
			 		+ "a file requested may be removed from file system,ignore it or"
			 		+ "BAD FILE IN DATABAE STORAGE FILE,PLEASE RECOVER SOON!");
			return null;
		}
		String pathOfImg=profile.getImage();
		
	    File img = new File(pathOfImg);
	    return ResponseEntity
	    		.ok()
	    		.contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
	    		.body(Files.readAllBytes(img.toPath()));
	}
	
	
	//给定指定路径名暴露一个图片的URL地址
	/**
	 * @param String imgLocalPath
	 * @return responsebody
	 * **/
	
	@GetMapping("/report/static/{name}.jpg")
	public ResponseEntity<byte[]> getStaticImage(@PathVariable("name") String name)throws IOException{
		 String root="src/main/resources/static/img/report/";
		 root=root+name+".jpg";
         		
		 File img=new File(root);
         if(img.exists()) {
		 return ResponseEntity
				.ok()
				.contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
				.body(Files.readAllBytes(img.toPath()));  
         }
         else {
        	 System.out.println("BAD FILE IN SERVER,PLEASE RECOVER SOON!");
        	 return null;
         }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
