package com.ty.fabrico.fabrico_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fabrico.fabrico_springboot.dto.CustomerEmail;

public interface CustomerEmailRepository extends JpaRepository<CustomerEmail, Integer>{

	public CustomerEmail getCustomerByCemail(String cemail);
		
	
}
