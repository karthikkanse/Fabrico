package com.ty.fabrico.fabrico_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fabrico.fabrico_springboot.dto.Cart;
import com.ty.fabrico.fabrico_springboot.service.CartService;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@RestController
@RequestMapping("cart")
public class CartController {
	
		@Autowired
		CartService cartService;

		@PostMapping
		public ResponseEntity<ResponseStructure<Cart>> saveCustomer(@RequestBody Cart cart,@RequestParam int customerid) {
			return cartService.saveCart(cart,customerid);
		}
		@PutMapping
		public ResponseEntity<ResponseStructure<Cart>> updateCustomer(@RequestBody Cart cart,@RequestParam  int cartId) {
			return cartService.updateCart(cart,cartId);
		}
		@GetMapping
		public ResponseEntity<ResponseStructure<Cart>> getCustomerById(@RequestParam int cartId) {
			return cartService.getCartById(cartId);
		}
		@DeleteMapping
		public ResponseEntity<ResponseStructure<Cart>> deleteCart(@RequestParam int cartId) {
			return cartService.deleteCart(cartId);
		}
	}



