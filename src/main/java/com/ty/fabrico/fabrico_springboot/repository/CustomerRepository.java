package com.ty.fabrico.fabrico_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fabrico.fabrico_springboot.dto.Customer;

<<<<<<< HEAD
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer getCustomerByName(String email);
=======
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer getCustomerByEmail(String email);
>>>>>>> karthik
}
