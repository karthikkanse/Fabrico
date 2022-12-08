package com.ty.fabrico.fabrico_springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fabrico.fabrico_springboot.dao.CartDao;
import com.ty.fabrico.fabrico_springboot.dto.Cart;
import com.ty.fabrico.fabrico_springboot.exception.NoSuchIdFoundException;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart){
		ResponseEntity<ResponseStructure<Cart>> responseEntity;

		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(cartDao.saveCart(cart));
		return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Cart>> updateCart(Cart cart,int cartId){
		ResponseEntity<ResponseStructure<Cart>> responseEntity;

		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		Optional<Cart> cart2 = cartDao.getCartById(cartId);
		if (cart2 != null) {
			cart.setCartId(cartId);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(cartDao.updateCart(cart));

		} else {

			throw new NoSuchIdFoundException();

		}
		return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Cart>> getCartById(int cartId) {
		ResponseEntity<ResponseStructure<Cart>> responseEntity;

		ResponseStructure<Cart> responseStructure = new ResponseStructure<Cart>();
		Optional<Cart> cart2 = cartDao.getCartById(cartId);
		if (cart2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(cart2.get());
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchIdFoundException();

		}

	}
	
	public ResponseEntity<ResponseStructure<Cart>> deleteCart(int cartId) {
		ResponseEntity<ResponseStructure<Cart>> responseEntity;
		ResponseStructure<Cart> responseStructure=new ResponseStructure<Cart>();
		Optional<Cart> optional = cartDao.getCartById(cartId);

		if (optional.isPresent()) {
			cartDao.deleteCart(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoSuchIdFoundException();

		}

	}

}
