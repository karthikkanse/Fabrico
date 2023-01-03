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
	@NotNull(message="Please Enter Your Name..It should not be null")
	private String customerName;
	@NotNull(message="Please enter Your Phoneno..It should not be null")
	@Convert(converter=AesEncryption.class)
	private long phone;
	@NotNull(message="Please enter Your Email..It should not be null")
	@Convert(converter=AesEncryption.class)
	@Column(unique = true)
	private String email;
	@NotNull(message="Please enter Your Password..It should not be null")
	@Convert(converter=AesEncryption.class)
	private String password;
	@NotNull(message="Please enter Your Address..It should not be null")
	private String address;
	private String premium;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Cart cart;
}
