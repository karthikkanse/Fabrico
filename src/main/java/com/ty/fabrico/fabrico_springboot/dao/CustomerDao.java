package com.ty.fabrico.fabrico_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fabrico.fabrico_springboot.dto.Customer;
import com.ty.fabrico.fabrico_springboot.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(int customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Customer getCustomerByEmail(Customer customer) {

		return customerRepository.getCustomerByEmail(customer.getEmail());
	}

	public Customer updateCustomer(Customer customer, int customerId) {
		Customer customer1 = getCustomerById(customerId);
		if (customer1 != null) {
			customer.setCustomerId(customerId);
			return customerRepository.save(customer);
		} else
			return null;
	}

	public String deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
		return "Deleted";
	}
}
