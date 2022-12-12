package com.ty.fabrico.fabrico_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fabrico.fabrico_springboot.dto.Customer;
import com.ty.fabrico.fabrico_springboot.service.CustomerService;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer,@RequestParam int customerId) {
		return customerService.updateCustomer(customer,customerId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam int customerId) {
		return customerService.getCustomerById(customerId);
	}
	@PatchMapping
	public ResponseEntity<ResponseStructure<Customer>> customerLogin(@RequestBody Customer customer) {
		return customerService.customerLogin(customer);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int customerId) {
		return customerService.deleteCustomer(customerId);
	}
}
