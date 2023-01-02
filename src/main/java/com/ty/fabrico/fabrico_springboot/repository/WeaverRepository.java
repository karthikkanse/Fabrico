package com.ty.fabrico.fabrico_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.fabrico.fabrico_springboot.dto.Weaver;

public interface WeaverRepository extends JpaRepository<Weaver, Integer>{
	
	public Weaver getWeaverByUsername(String username);

//	@Query(value = "Delete from WeaverProduct c where c.weaver.weaverid=?1")
//	public void deleteProductForWeaver(int weaverid);
}
