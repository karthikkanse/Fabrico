package com.ty.fabrico.fabrico_springboot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class CustomerDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull
	private String customerName;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String address;
	private String premium;

}
