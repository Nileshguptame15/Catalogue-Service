package com.applicateAI.CatalogueService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalog")
public class Catalog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sku_code")
	private int skuCode;
	@Column(name="sku_Name")
	private String skuName;
	@Column(name="sku_Description")
	private String skuDescription;
	@Column(name="brand_Name")
	private String brandName;
	@Column(name="brand_Description")
	private String brandDescription;
	@Column(name="supplier_Id")
	private int supplierId;
	
	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalog(String skuName, String skuDescription, String brandName, String brandDescription,
			int supplierId) {
		super();
		this.skuName = skuName;
		this.skuDescription = skuDescription;
		this.brandName = brandName;
		this.brandDescription = brandDescription;
		this.supplierId = supplierId;
	}
	public void setSkuCode(int skuCode) {
		this.skuCode= skuCode;
	}
	public int getSkuCode() {
		return skuCode;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getSkuDescription() {
		return skuDescription;
	}
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	public int getSupplierId() {
		return supplierId;
	}
	
}
