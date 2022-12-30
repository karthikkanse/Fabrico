package com.ty.fabrico.fabrico_springboot.controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.fabrico.fabrico_springboot.dto.Product;
import com.ty.fabrico.fabrico_springboot.repository.ProductRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProductControllerTest {

	@Autowired
	ProductRepository  productRepo;
	
	
	@Test
	@Order(1)
	void testSaveProductForWeaver() {
		
		Product product=new Product();
		product.setPId(1);
		product.setProductName("Saree");
		product.setProductPrice(100);
		product.setQuantity(2);
		productRepo.save(product);
		assertNotNull(productRepo.findById(product.getPId()).get());
	
	}

	@Test
	@Order(2)
	void testSaveProductForCustomer() {
		Product product=new Product();
		product.setPId(2);
		product.setProductName("Saree2");
		product.setProductPrice(150);
		product.setQuantity(3);
		productRepo.save(product);
		assertNotNull(productRepo.findById(product.getPId()).get());
	}

	@Test
	@Order(3)
	void testGetProductById() {
		productRepo.findById(1).get();
	}

	@Test
	@Order(4)
	void testUpdateProductById() {
		Product product=productRepo.findById(1).get();
		product.setProductName("");
		product.setProductPrice(0);
		productRepo.save(product);
		assertNotNull(productRepo.findById(product.getPId()).get());
	}

	@Test
	@Order(5)
	void testDeleteProductById() {
		productRepo.deleteById(1);
	}

}
