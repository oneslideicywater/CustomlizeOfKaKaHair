package com.oneslide.RestfulCheck;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.oneslide.RestfulCheck.service.PopulateCustomer;
import com.oneslide.RestfulCheck.storage.StorageProperties;
import com.oneslide.RestfulCheck.storage.StorageService;





@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class RestfulCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulCheckApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner init(StorageService storageService,PopulateCustomer popu) {
	     return (args) -> {
	            storageService.deleteAll();
	            storageService.init();
	       
	            popu.populate();
	            //需要初始化一些用户信息以备测试
	            
	         
	        };
	}
}
