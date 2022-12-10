package com.ty.fabrico.fabrico_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fabrico.fabrico_springboot.dto.Product;
import com.ty.fabrico.fabrico_springboot.service.ProductService;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProductForWeaver(@RequestBody Product product,@RequestParam int weaverid) {
		return  productService.saveProductForWeaver(product, weaverid);
	}
	
	@PatchMapping
	public ResponseEntity<ResponseStructure<Product>> saveProductForCustomer(@RequestBody Product product,@RequestParam int customerid){
		return productService.saveProductForCustomer(product, customerid);
	}
}
