package com.ty.fabrico.fabrico_springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ty.fabrico.fabrico_springboot.dto.Cart;
import com.ty.fabrico.fabrico_springboot.dto.Customer;
import com.ty.fabrico.fabrico_springboot.dto.CustomerProduct;
import com.ty.fabrico.fabrico_springboot.dto.WeaverProduct;
import com.ty.fabrico.fabrico_springboot.exception.CartNotFoundException;
import com.ty.fabrico.fabrico_springboot.exception.NoSuchIdFoundException;
import com.ty.fabrico.fabrico_springboot.repository.CustomerProductRepository;
import com.ty.fabrico.fabrico_springboot.repository.WeaverProductRepository;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@Repository
public class CustomerProductDao {
	
	@Autowired
	CustomerProductRepository productRepository;
	
	public CustomerProduct saveProduct(CustomerProduct product)
	{
		return productRepository.save(product);
	}
	
	public Optional<CustomerProduct> getProductById(int productId)
	{
		return productRepository.findById(productId);
	}
	
	public CustomerProduct updateProduct(CustomerProduct product)
	{
		return productRepository.save(product);
	}
	
	public void deleteProduct(CustomerProduct product)
	{
		 productRepository.delete(product);
	}
	
	public List<CustomerProduct> getAllProduct(){
		return productRepository.findAll();
	}

	
}
