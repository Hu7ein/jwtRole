package com.husen.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husen.jwt.entity.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

}
