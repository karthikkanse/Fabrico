package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull
	private String customerName;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private long phone;
	@NotNull
	@Convert(converter=AesEncryption.class)
	@Column(unique = true)
	private String email;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private String password;
	@NotNull
	private String address;
	private String premium;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Cart cart;
}
