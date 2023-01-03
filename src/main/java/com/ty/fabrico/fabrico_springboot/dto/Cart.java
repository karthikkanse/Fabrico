package com.ty.fabrico.fabrico_springboot.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@NotNull(message="Fill The CartName..It Should Not Be Empty")
	private String cartName;
	@NotNull(message="Fill The Totalcost...It Should Not Be Empty")
	private double totalcost;
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JsonIgnore
	List<Product> product;
	
	

}
