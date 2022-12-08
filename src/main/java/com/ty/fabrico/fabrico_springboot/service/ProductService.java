package com.ty.fabrico.fabrico_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.fabrico.fabrico_springboot.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	ProductDao productdao;
	
	
}
