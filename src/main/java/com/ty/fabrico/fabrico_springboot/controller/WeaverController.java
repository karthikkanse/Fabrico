package com.ty.fabrico.fabrico_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
}
