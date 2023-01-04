package com.ty.fabrico.fabrico_springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fabrico.fabrico_springboot.dao.CustomerDao;
import com.ty.fabrico.fabrico_springboot.dao.CustomerProductDao;
import com.ty.fabrico.fabrico_springboot.dao.WeaverDao;
import com.ty.fabrico.fabrico_springboot.dto.Cart;
import com.ty.fabrico.fabrico_springboot.dto.Customer;
import com.ty.fabrico.fabrico_springboot.dto.CustomerProduct;
import com.ty.fabrico.fabrico_springboot.exception.CartNotFoundException;
import com.ty.fabrico.fabrico_springboot.exception.NoSuchIdFoundException;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@Service
public class CustomerProductService {

	public static final Logger LOGGER = Logger.getLogger(CustomerProductService.class);
	@Autowired
	CustomerProductDao productDao;

	@Autowired
	WeaverDao weaverDao;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CartService cartService;
	
	public ResponseEntity<ResponseStructure<CustomerProduct>> saveProductForCustomer(int productid, int customerid) {
		ResponseStructure<CustomerProduct> responseStructure = new ResponseStructure<CustomerProduct>();
		ResponseEntity<ResponseStructure<CustomerProduct>> responseEntity;
		Optional<Customer> optional = customerDao.getCustomerById(customerid);
		Optional<CustomerProduct> optional2 = productDao.getProductById(productid);
		CustomerProduct product;
		Customer customer;
		if (optional.isPresent()) {
			LOGGER.debug("Customer found");
			customer = optional.get();
		} else {
			LOGGER.error("Customer not found to add products");
			throw new NoSuchIdFoundException("No Such Id Found For Customer");
		}
		if (optional2.isPresent()) {
			LOGGER.debug("Product found");
			product = optional2.get();
		} else {
			LOGGER.error("Product not found to add");
			throw new NoSuchIdFoundException("No Such Id Found For Product");
		}
		if (customer != null) {
			Cart cart = customer.getCart();
			if (cart != null) {
				if (cart.getCustomerProduct() != null) {
					List<CustomerProduct> products = cart.getCustomerProduct();
					products.add(product);
					responseStructure.setStatus(HttpStatus.CREATED.value());
					responseStructure.setMessage("Product Saved To Cart");
					responseStructure.setData(product);
					cartService.updateCart(cart, cart.getCartId());
					customerDao.updateCustomer(customer);
					LOGGER.debug("Products add to customer");
				} else {
					List<CustomerProduct> products = new ArrayList<CustomerProduct>();
					products.add(product);
					responseStructure.setStatus(HttpStatus.CREATED.value());
					responseStructure.setMessage("Product Saved To Cart");
					responseStructure.setData(product);
					cartService.updateCart(cart, cart.getCartId());
					customerDao.updateCustomer(customer);
					LOGGER.debug("Products add to customer");
				}
			} else {
				LOGGER.error("Trying to insert products to null cart");
				throw new CartNotFoundException();
			}
		}
		return responseEntity = new ResponseEntity<ResponseStructure<CustomerProduct>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<CustomerProduct>> getCustomerProductById(int productid) {
		ResponseStructure<CustomerProduct> responseStructure = new ResponseStructure<CustomerProduct>();
		ResponseEntity<ResponseStructure<CustomerProduct>> responseEntity;
		Optional<CustomerProduct> optional = productDao.getProductById(productid);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product Found");
			responseStructure.setData(optional.get());
			LOGGER.debug("Products found");
			return responseEntity = new ResponseEntity<ResponseStructure<CustomerProduct>>(responseStructure, HttpStatus.OK);
		} else {
			LOGGER.error("Product not found");
			throw new NoSuchIdFoundException("Product Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerProduct>> deleteCustomerProduct(int productid) {
		ResponseStructure<CustomerProduct> responseStructure = new ResponseStructure<CustomerProduct>();
		ResponseEntity<ResponseStructure<CustomerProduct>> responseEntity;
		Optional<CustomerProduct> optional = productDao.getProductById(productid);
		if (optional.isPresent()) {
			productDao.deleteProduct(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			LOGGER.warn("Product deleted");
			return responseEntity = new ResponseEntity<ResponseStructure<CustomerProduct>>(responseStructure, HttpStatus.OK);
		} else {
			LOGGER.error("Product not found to delete");
			throw new NoSuchIdFoundException("No Such Id Found Unable To Delete");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerProduct>> updateCustomerProduct(CustomerProduct product, int productid) {
		Optional<CustomerProduct> optional = productDao.getProductById(productid);
		CustomerProduct product2;
		ResponseStructure<CustomerProduct> responseStructure = new ResponseStructure<CustomerProduct>();
		ResponseEntity<ResponseStructure<CustomerProduct>> responseEntity;
		if (optional.isPresent()) {
			product2 = optional.get();
		} else {
			product2 = null;
		}
		if (product2 != null) {
			product.setCpId(productid);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(productDao.updateProduct(product));
			LOGGER.debug("Product updated");
			return responseEntity = new ResponseEntity<ResponseStructure<CustomerProduct>>(responseStructure, HttpStatus.OK);
		} else {
			LOGGER.error("Product not found to update");
			throw new NoSuchIdFoundException("No Such Id Found Unable To Update");
		}

	}
}