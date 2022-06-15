package com.husen.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husen.jwt.entity.CategoryDetails;

public interface ProductCategoriesRepository extends JpaRepository<CategoryDetails, Integer> {

}
