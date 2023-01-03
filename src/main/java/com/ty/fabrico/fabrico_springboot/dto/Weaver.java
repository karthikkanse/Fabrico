package com.ty.fabrico.fabrico_springboot.dto;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;

@Entity
@Data
public class Weaver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weaverid;	
	private String weavername;
	@Email
	@Column(unique = true)
	private String username;
	@NotEmpty
	@Convert(converter=AesEncryption.class)
	@Size(message = "Password should not be empty")
	private String password;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private long phone;
	@NotNull(message = "Enter the address")
	@Convert(converter=AesEncryption.class)
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<WeaverProduct> weaverProduct;
	
}
