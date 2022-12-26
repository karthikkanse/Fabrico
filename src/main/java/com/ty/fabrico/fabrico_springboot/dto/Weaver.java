package com.ty.fabrico.fabrico_springboot.dto;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;

@Entity
@Data
public class Weaver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int weaverid;	
	@NotNull
	private String weavername;
	@NotNull
	@Column(unique = true)
	private String username;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private String password;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private long phone;
	@NotNull
	@Convert(converter=AesEncryption.class)
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL/*,mappedBy = "weaver"*/)
	List<Product> product;
	
}
