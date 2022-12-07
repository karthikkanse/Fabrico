package com.ty.fabrico.fabrico_springboot.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.fabrico.fabrico_springboot.dto.Product;
import com.ty.fabrico.fabrico_springboot.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Product getProductById(int productId)
	{
		Optional<Product> optional=productRepository.findById(productId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		else 
			return null;
	}
	
	public Product updateProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public String deleteProduct(int productId)
	{
		productRepository.deleteById(productId);
		return "Deleted";
	}
}
