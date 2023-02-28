package com.ty.fabrico.fabrico_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fabrico.fabrico_springboot.dto.WeaverEmail;
import com.ty.fabrico.fabrico_springboot.repository.WeaverEmailRepository;

@Repository
public class WeaverEmailDao {

	@Autowired
	WeaverEmailRepository emailRepository;
	
	public WeaverEmail getWeaverByEmail(String email) {
		return emailRepository.getWeaverByWemail(email);
	}
}
