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
@Table(name = "category_details")
public class CategoryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private int cid;
	@Column
	private String cname;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductDetails> product;

	public CategoryDetails() {
	}

	public CategoryDetails(int cid, String cname, Set<ProductDetails> product) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.product = product;

	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@JsonManagedReference
	public Set<ProductDetails> getProduct() {
		return product;
	}

	public void setProduct(Set<ProductDetails> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", product=" + product + "]";
	}

}
