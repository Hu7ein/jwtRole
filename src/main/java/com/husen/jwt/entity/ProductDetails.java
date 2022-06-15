package com.husen.jwt.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private int pid;
	@Column
	private String pname;
	@Column
	private int price;
	@Column
	private int quantity;
	@Column
	private Date date;

	@ManyToOne()
	@JoinColumn(name = "fk_cid")
	private CategoryDetails category;

	@ManyToOne()
	@JoinColumn(name = "fk_wid")
	private WarehouseDetails warehouse;

	public ProductDetails() {
	}

	public ProductDetails(int pid, String pname, int price, int quantity, Date date, CategoryDetails category,
			WarehouseDetails warehouse) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.date = date;
		this.category = category;
		this.warehouse = warehouse;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonBackReference(value="Warehouse-Details")
	public WarehouseDetails getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseDetails warehouse) {
		this.warehouse = warehouse;
	}

	@JsonBackReference
	public CategoryDetails getCategory() {
		return category;
	}

	public void setCategory(CategoryDetails category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", date="
				+ date + ", warehouse=" + warehouse + ", category=" + category + "]";
	}

}
