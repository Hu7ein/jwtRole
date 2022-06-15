package com.husen.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.husen.jwt.entity.WarehouseDetails;
import com.husen.jwt.service.WarehouseDetailsService;

@RestController
@RequestMapping(value="/warehouse")
@CrossOrigin
public class WarehouseController {
	@Autowired
	WarehouseDetailsService wservice;

	@PostMapping("/")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<WarehouseDetails> addWarehouse(@RequestBody WarehouseDetails warehouse) {
		return new ResponseEntity<WarehouseDetails>(wservice.saveproduct(warehouse), HttpStatus.CREATED);
	}

	@GetMapping("/")
	@PreAuthorize("hasAnyRole('Admin','User')")
	public List<WarehouseDetails> getAllproducts() {
		return wservice.findAll();
	}

}
