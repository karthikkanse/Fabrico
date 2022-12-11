package com.ty.fabrico.fabrico_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fabrico.fabrico_springboot.dto.Weaver;
import com.ty.fabrico.fabrico_springboot.service.WeaverService;
import com.ty.fabrico.fabrico_springboot.util.ResponseStructure;

@RestController
@RequestMapping("weaver")
public class WeaverController {

	@Autowired
	WeaverService weaverService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Weaver>> saveWeaver(@RequestBody Weaver weaver) {
		return weaverService.saveWeaver(weaver);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Weaver>> getWeaverById(@RequestParam int weaverid){
		return weaverService.getWeaverById(weaverid);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Weaver>> deleteWeaver(@RequestParam int weaverid){
		return weaverService.deleteWeaver(weaverid);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Weaver>> updateWeaver(@RequestBody Weaver weaver,@RequestParam int weaverid) {
		return weaverService.updateWeaver(weaver, weaverid);
	}
	
	@PatchMapping
	public ResponseEntity<ResponseStructure<Weaver>> weaverLogin(@RequestBody Weaver weaver){
		return weaverService.weaverLogin(weaver);
	}
	
	
	
}
