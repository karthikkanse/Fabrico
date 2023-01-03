package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private long phone;
	@NotEmpty
	@Email
	@Column(unique = true)
	@Convert(converter=AesEncryption.class)
	private String email;
	@NotEmpty
	@Convert(converter=AesEncryption.class)
	@Size(message = "Password should not be empty")
	private String password;
	@Convert(converter=AesEncryption.class)
	private String address;
	private String premium;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Cart cart;
}
