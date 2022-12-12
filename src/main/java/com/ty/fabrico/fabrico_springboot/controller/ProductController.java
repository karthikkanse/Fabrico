package com.ty.fabrico.fabrico_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fabrico.fabrico_springboot.dto.Product;
import com.ty.fabrico.fabrico_springboot.service.ProductService;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@ApiOperation(value="Save Product for Weaver" , notes="It is used to Save the Product Details for Weaver")
	@ApiResponses(value= {@ApiResponse(code=201, message="Created"),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=404, message="Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {
		MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Product>> saveProductForWeaver(@RequestBody Product product,@RequestParam int weaverid) {
		return  productService.saveProductForWeaver(product, weaverid);
	}
	
	@ApiOperation(value="Save Product for Customer" , notes="It is used to Save the Product Details for Customer")
	@ApiResponses(value= {@ApiResponse(code=201, message="Created"),
			@ApiResponse(code=500, message="Internal Server Error"),
			@ApiResponse(code=404, message="Not Found")})
	@PatchMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces= {
		MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Product>> saveProductForCustomer(@RequestBody Product product,@RequestParam int customerid){
		return productService.saveProductForCustomer(product, customerid);
	}
}
