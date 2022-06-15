package com.husen.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husen.jwt.entity.CategoryDetails;
import com.husen.jwt.dao.ProductCategoriesRepository;

@Service
public class ProductCategoriesService {
	@Autowired
	ProductCategoriesRepository crepo;

	public CategoryDetails savecategory(CategoryDetails category) {
		return crepo.save(category);
	}

	public List<CategoryDetails> findAll() {
		return crepo.findAll();
	}
}
