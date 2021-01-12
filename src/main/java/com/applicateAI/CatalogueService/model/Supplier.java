package com.applicateAI.CatalogueService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "supplier_Id")
	private int supplierId;
	@Column(name = "supplier_Name")
	private String supplierName;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(String supplierName) {
		super();
		this.supplierName = supplierName;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId=supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
