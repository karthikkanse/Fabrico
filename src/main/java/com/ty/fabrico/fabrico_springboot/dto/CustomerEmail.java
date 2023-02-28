package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class CustomerEmail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@NotEmpty(message = "E-mail should not be empty")
	@Email
	@Column(unique = true)
	@Convert(converter=AesEncryption.class)
	private String cemail;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Customer customer;
}
