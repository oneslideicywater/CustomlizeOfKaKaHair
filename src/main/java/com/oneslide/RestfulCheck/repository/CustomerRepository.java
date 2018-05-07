package com.oneslide.RestfulCheck.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneslide.RestfulCheck.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
  
   Customer findByOpenid(long openid);
   Customer findById(long id);
	
}
