package com.ty.fabrico.fabrico_springboot.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.fabrico.fabrico_springboot.dao.ProductDao;
import com.ty.fabrico.fabrico_springboot.dto.Product;
import com.ty.fabrico.fabrico_springboot.exception.NoSuchIdFoundException;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity;

		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product Saved");
		responseStructure.setData(productDao.saveProduct(product));
		return responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int productId) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity;
		Optional<Product> optional = productDao.getProductById(productId);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product Found");
			responseStructure.setData(optional.get());
			return responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else
			throw new NoSuchIdFoundException("Product Id Not Found");
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity;
		Optional<Product> optional = productDao.getProductById(productId);
		if (optional.isPresent()) {
			productDao.deleteProduct(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			return responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else
			throw new NoSuchIdFoundException();

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, int productId) {
		Product product2 = productDao.getProductById(productId).get();
		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity;

		if (product2 != null) {
			product.setPId(productId);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(productDao.updateProduct(product));
			return responseEntity = new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);

		}

		else
			throw new NoSuchIdFoundException("No Id Found Unable To Update");
	}

}
