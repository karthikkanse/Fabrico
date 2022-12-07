package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity

public class WeaverDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weaverid;
	private String weavername;
	private String username;
	private String password;
	private long phone;
	private String address;
	
}
