package com.applicateAI.CatalogueService.model;

public class Catalog {
	private static int count;
	private int skuCode;
	private String skuName;
	private String skuDescription;
	private String brandName;
	private String brandDescription;
	private int supplierId;
	
	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Catalog(String skuName, String skuDescription, String brandName, String brandDescription,
			int supplierId) {
		super();
		this.skuCode = count++;
		this.skuName = skuName;
		this.skuDescription = skuDescription;
		this.brandName = brandName;
		this.brandDescription = brandDescription;
		this.supplierId = supplierId;
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
