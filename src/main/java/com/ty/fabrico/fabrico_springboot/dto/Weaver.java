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
	@NotNull(message="Please enter Your Name..It should not be null")
	private String weavername;
	@NotNull(message="Please enter Your UserName..It should not be null")
	@Column(unique = true)
	private String username;
	@NotNull(message="Please enter Your Password..It should not be null")
	@Convert(converter=AesEncryption.class)
	private String password;
	@NotNull(message="Please enter Your Phoneno..It should not be null")
	@Convert(converter=AesEncryption.class)
	private long phone;
	@NotNull(message="Please enter Your Address..It should not be null")
	@Convert(converter=AesEncryption.class)
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL/*,mappedBy = "weaver"*/)
	List<Product> product;
	
}
