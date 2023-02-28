package com.ty.fabrico.fabrico_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fabrico.fabrico_springboot.dto.CustomerEmail;
import com.ty.fabrico.fabrico_springboot.repository.CustomerEmailRepository;

@Repository
public class CustomerEmailDao {

	@Autowired
	private CustomerEmailRepository customerEmailRepository;
	
	public CustomerEmail getCustomerByEmail(String cemail) {
		return customerEmailRepository.getCustomerByCemail(cemail);
	}
}
