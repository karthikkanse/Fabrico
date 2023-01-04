package com.ty.fabrico.fabrico_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.fabrico.fabrico_springboot.dto.CustomerProduct;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Integer>{

}
