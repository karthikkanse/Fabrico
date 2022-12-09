package com.ty.fabrico.fabrico_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fabrico.fabrico_springboot.dao.CartDao;
import com.ty.fabrico.fabrico_springboot.dto.Cart;
import com.ty.fabrico.fabrico_springboot.dto.Product;
import com.ty.fabrico.fabrico_springboot.exception.NoSuchIdFoundException;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart) {
		ResponseEntity<ResponseStructure<Cart>> responseEntity;
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		List<Product> product = cart.getProduct();
		double totalcost = 0;
		int quantity=0;
		for (Product products2 : product) {
<<<<<<< HEAD
			totalcost += (products2.getProductPrice() * products2.getQuantity());
			quantity+=products2.getQuantity();
=======
			totalcost = totalcost + (products2.getProductPrice() * products2.getQuantity());
>>>>>>> 5d6be703c1f53425f664932a0cd83cb2d0090089
		}
		
		if(quantity>=10 && quantity<20) {
			totalcost =  totalcost-(totalcost * 0.10);
		}else if(quantity>=20 && quantity<35) {
			totalcost =  totalcost-(totalcost * 0.20);
		}else if(quantity>=40) {
			totalcost =  totalcost-(totalcost * 0.35);
		}
		
		cart.setTotalcost(totalcost);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(cartDao.saveCart(cart));
		return responseEntity=new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.CREATED);

	}

	
	public ResponseEntity<ResponseStructure<Cart>> updateCart(Cart cart, int cartId) {
		ResponseEntity<ResponseStructure<Cart>> responseEntity;
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		Optional<Cart> optional = cartDao.getCartById(cartId);
		if (optional.isPresent()) {
			cart.setCartId(cartId);
			List<Product> products = cart.getProduct();
			double totalcost = 0;
			int quantity=0;
			for (Product products2 : products) {
<<<<<<< HEAD
				totalcost +=(products2.getProductPrice() * products2.getQuantity());
				quantity+=products2.getQuantity();
=======
				totalcost = totalcost + (products2.getProductPrice() * products2.getQuantity());
>>>>>>> 5d6be703c1f53425f664932a0cd83cb2d0090089
			}
			if(quantity>=10 && quantity<20) {
				totalcost =  totalcost-(totalcost * 0.10);
			}else if(quantity>=20 && quantity<35) {
				totalcost =  totalcost-(totalcost * 0.20);
			}else if(quantity>=40) {
				totalcost =  totalcost-(totalcost * 0.35);
			}
			
			cart.setTotalcost(totalcost);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(cartDao.updateCart(cart));

		} else {

			throw new NoSuchIdFoundException();

		}
		return responseEntity=new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Cart>> getCartById(int cartId) {
		ResponseEntity<ResponseStructure<Cart>> responseEntity;
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		Optional<Cart> optional = cartDao.getCartById(cartId);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(optional.get());
			return responseEntity = new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchIdFoundException();

		}

	}

	public ResponseEntity<ResponseStructure<Cart>> deleteCart(int cartId) {
		ResponseEntity<ResponseStructure<Cart>> responseEntity;
		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		Optional<Cart> optional = cartDao.getCartById(cartId);

		if (optional.isPresent()) {
			cartDao.deleteCart(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			return responseEntity=new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoSuchIdFoundException();

		}
	}

}
