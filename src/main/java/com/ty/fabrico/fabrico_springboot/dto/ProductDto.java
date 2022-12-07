package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductDto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productId;
	String productName;
	double productPrice;
	
	
}
