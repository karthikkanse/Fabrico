package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class CustomerProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cpId;
	@NotNull
	private String productName;
	@NotNull
	private double productPrice;
	@NotNull
	private int quantity;
}
