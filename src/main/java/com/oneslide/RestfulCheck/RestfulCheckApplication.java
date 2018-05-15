package com.oneslide.RestfulCheck;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.oneslide.RestfulCheck.storage.StorageProperties;
import com.oneslide.RestfulCheck.storage.StorageService;


//

@SpringBootApplication//(exclude = { DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableConfigurationProperties(StorageProperties.class)
public class RestfulCheckApplication extends SpringBootServletInitializer{
  
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(RestfulCheckApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestfulCheckApplication.class);
	}

	
	
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
	     return (args) -> {
	            //storageService.deleteAll();
	            storageService.init();
	       
	            //popu.populate();
	            //需要初始化一些用户信息以备测试
	            
	         
	        };
	}
}
