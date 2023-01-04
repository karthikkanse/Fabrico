package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class WeaverProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int wpId;
	@NotEmpty
	String productName;
	@NotNull(message = "Product price cannot be null")
	double productPrice;
	@NotNull(message="Product quantity cannot be null")
	private int quantity;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn
//	private Weaver weaver;


}
