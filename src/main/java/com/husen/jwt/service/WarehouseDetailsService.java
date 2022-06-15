package com.husen.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husen.jwt.entity.WarehouseDetails;
import com.husen.jwt.dao.WarehouseDetailsRepository;

@Service
public class WarehouseDetailsService {
	@Autowired
	WarehouseDetailsRepository wrepo;

	public WarehouseDetails saveproduct(WarehouseDetails warehouse) {
		return wrepo.save(warehouse);
	}

	public List<WarehouseDetails> findAll() {
		return wrepo.findAll();
	}

}
