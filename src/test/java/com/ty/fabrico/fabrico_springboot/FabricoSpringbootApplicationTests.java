package com.ty.fabrico.fabrico_springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.fabrico.fabrico_springboot.dto.Customer;
import com.ty.fabrico.fabrico_springboot.repository.CustomerRepository;

@SpringBootTest
class FabricoSpringbootApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void testSave() {
		Customer customer=new Customer();
		customer.setCustomerName("Umesh");
		customer.setPhone(8296);
		customer.setEmail("umesh@gmail.com");
		customer.setPassword("123");
		customer.setAddress("Bangalore");
		customerRepository.save(customer);
		assertNotNull(customerRepository.findById(customer.getCustomerId()).get());
	}
	
	@Test
	public void testGetCustomer()	{
		Customer customer=customerRepository.findById(1).get();
		assertEquals(1,customer.getCustomerId());
	}
	
	@Test
	public void testUpdateCustomer()	{
		Customer customer=customerRepository.findById(1).get();
		customer.setCustomerName("Mahesh");
		customer.setPhone(7896);
		customer.setEmail("mahesh@gmail.com");
		customer.setPassword("456");
		customer.setAddress("Mangalore");
		customerRepository.save(customer);
		assertNotNull(customerRepository.findById(customer.getCustomerId()).get());
	}
	
	@Test
	public void testDeleteCustomer()	{
		Customer customer=customerRepository.findById(12).get();
		customerRepository.deleteById(customer.getCustomerId());
		assertEquals(12,customer.getCustomerId());
	}
	
	@Test
	public void testLoginCustomer()	{
		String email="umesh@gmail.com";
		String password="123";
		Customer customer=customerRepository.findById(13).get();
		assertEquals(email, customer.getEmail());
	}

}
