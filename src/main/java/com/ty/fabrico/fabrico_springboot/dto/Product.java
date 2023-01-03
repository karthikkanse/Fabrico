package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pId;
	@NotNull(message="Please enter Your Productname..It should not be null")
	String productName;
	@NotNull(message="Please enter Your Productprice..It should not be null")
	double productPrice;
	@NotNull(message="Please enter Your quantity..It should not be null")
	private int quantity;

	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Weaver weaver;*/
	

}
