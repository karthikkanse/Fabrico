package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class WeaverDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weaverid;
	@NotNull
	private String weavername;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private long phone;
	@NotNull
	private String address;
	
}
