package com.husen.jwt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

@Table(name = "warehouse_detail")
public class WarehouseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "w_id")
	private int wid;
	@Column
	private String wname;
	@Column
	private String location;

	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductDetails> product;

	public WarehouseDetails() {
	}

	public WarehouseDetails(int wid, String wname, String location, Set<ProductDetails> product) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.location = location;
		this.product = product;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@JsonManagedReference(value="Warehouse-Details")
	public Set<ProductDetails> getProduct() {
		return product;
	}

	public void setProduct(Set<ProductDetails> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "WarehouseDetails [wid=" + wid + ", wname=" + wname + ", location=" + location + ", product=" + product
				+ "]";
	}

}
