package com.husen.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.husen.jwt.entity.ProductDetails;
import com.husen.jwt.dao.ProductDetailsRepository;

@Service
public class ProductDetailsService {
	
	@Autowired
	ProductDetailsRepository prepo;

	public ProductDetails saveproduct(ProductDetails product) {
		return prepo.save(product);
	}

	public List<ProductDetails> findAll() {
		return prepo.findAll();
	}

	public ProductDetails updateproduct(ProductDetails product, int pid) {
		return prepo.save(product);
	}

	public void deleteproduct(int pid) {
		prepo.deleteById(pid);
	}
}
