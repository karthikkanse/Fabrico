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
public class WeaverEmail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weid;
	@NotEmpty(message = "Email should not be empty")
	@Email
	@Column(unique = true)
	@Convert(converter=AesEncryption.class)
	private String wemail;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Weaver weaver;
}
