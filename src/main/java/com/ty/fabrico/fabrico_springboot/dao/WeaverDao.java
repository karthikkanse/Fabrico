package com.ty.fabrico.fabrico_springboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fabrico.fabrico_springboot.dto.Weaver;
import com.ty.fabrico.fabrico_springboot.repository.WeaverRepository;

@Repository
public class WeaverDao {

	@Autowired
	WeaverRepository weaverRepository;
	
	public Weaver saveWeaver(Weaver weaver) {
		return weaverRepository.save(weaver);
	}
	
	public Weaver getWeaverById(int weaverId) {
	    Optional<Weaver> optional=  weaverRepository.findById(weaverId);
	    if(optional.isPresent()) {
	    	return optional.get();
	    }else {
	    	return null;
	    }
	}
	
	public Weaver updateWeaver(Weaver weaver,int weaverId) {

		Weaver weaver2=getWeaverById(weaverId);
		if(weaver2!=null) {
			weaver.setWeaverid(weaverId);
			return weaverRepository.save(weaver);
		}else {
			return null;
		}
	}
	
	public String deleteWeaver(int weaverid) {
		weaverRepository.deleteById(weaverid);
		return "Deleted";
	}
	
	public Weaver getWeaverByName(Weaver weaver) {
		return weaverRepository.getWeaverByUsername(weaver.getUsername());
	}
	
}
