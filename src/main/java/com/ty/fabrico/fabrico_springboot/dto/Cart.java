package com.ty.fabrico.fabrico_springboot.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@NotNull
	private String cartName;
	@NotNull
	private int cartQuantity;
	@NotNull
	private long phone;
	@NotNull
	private double totalcost;
	
	@OneToMany
	@JoinColumn
	List<Product> product;

}
