package com.husen.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husen.jwt.entity.ProductDetails;
import com.husen.jwt.service.ProductDetailsService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductDetailsService service;

	@PostMapping("/new")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<ProductDetails> saveproduct(@RequestBody ProductDetails product) {
		service.saveproduct(product);
		return new ResponseEntity<ProductDetails>(service.saveproduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	@PreAuthorize("hasAnyRole('Admin','User')")
	public List<ProductDetails> getAllproducts() {
		return service.findAll();
	}

	@PutMapping("/update/{pid}")
	@PreAuthorize("hasAnyRole('Admin','User')")
	public ProductDetails updateproduct(@RequestBody ProductDetails product, @PathVariable("pid") int pid) {
		return service.updateproduct(product, pid);
	}

	@DeleteMapping("/deleteProduct/{pid}")
	@PreAuthorize("hasRole('Admin')")
	public void deleteproduct(@PathVariable("pid") int pid) {
		service.deleteproduct(pid);
	}

}