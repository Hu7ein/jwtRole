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

import com.husen.jwt.entity.CategoryDetails;

import com.husen.jwt.service.ProductCategoriesService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	@Autowired
	ProductCategoriesService cservice;

	@PostMapping("/new")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<CategoryDetails> addCategory(@RequestBody CategoryDetails category) {
		return new ResponseEntity<CategoryDetails>(cservice.savecategory(category), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('Admin','User')")
	public List<CategoryDetails> getAllproducts() {
		return cservice.findAll();
	}
}
