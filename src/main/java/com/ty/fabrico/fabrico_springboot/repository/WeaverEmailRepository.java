package com.ty.fabrico.fabrico_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fabrico.fabrico_springboot.dto.WeaverEmail;

public interface WeaverEmailRepository extends JpaRepository<WeaverEmail, Integer> {

	public WeaverEmail getWeaverByWemail(String wemail);
}
