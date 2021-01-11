package com.applicateAI.CatalogueService.model;

public class Supplier {

	private static int count;
	private int supplierId;
	private String supplierName;
	
	public Supplier(String supplierName) {
		super();
		this.supplierId = count++;
		this.supplierName = supplierName;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
