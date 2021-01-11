package com.applicateAI.CatalogueService.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.applicateAI.CatalogueService.model.Catalog;
import com.applicateAI.CatalogueService.model.Supplier;

@Repository
public class CatalogueDAOImpl implements CatalogueDAO {

	private static List<Supplier> supplierList = new ArrayList<Supplier>();
	private static List<Catalog> catalogueList = new ArrayList<Catalog>();
	
	static {
		/*
		 * Populating Suupliers
		 */
		supplierList.add(new Supplier("A"));
		supplierList.add(new Supplier("B"));
		
		/*
		 * Populating Catalogue
		 */
		catalogueList.add(new Catalog("Haldiram Namkeen", null, null, null, supplierList.get(0).getSupplierId()));
		catalogueList.add(new Catalog("Bingo 200 gm", null, null, null, supplierList.get(0).getSupplierId()));
		catalogueList.add(new Catalog("Bingo 500 gm", null, null, null, supplierList.get(0).getSupplierId()));
		catalogueList.add(new Catalog("Ashirwad Atta", null, "Ashirwad Atta", "Atta", supplierList.get(1).getSupplierId()));
		catalogueList.add(new Catalog("Samrat Atta", null, "Samrat Atta", "Atta", supplierList.get(1).getSupplierId()));
	}
	
	@Override
	public List<Catalog> searchItems(String supplierName, String serachItem) {
		List<Catalog> result = new ArrayList();
		int supplierId = -1;
		/*
		 * Looking for supplier Id for foreign key in Catalog
		 * if not found by default value is -1
		 */
		for(Supplier supplier: supplierList) {
			if(supplier.getSupplierName().equalsIgnoreCase(supplierName)) {
				supplierId = supplier.getSupplierId();
				break;
			}
		}
		System.out.println(supplierId);
		/*
		 * Adding Catalog into list by search Results
		 */
		for(Catalog catalog: catalogueList) {
			System.out.println(catalog.getSkuName());
			if(catalog.getSupplierId() == supplierId && catalog.getSkuName().toLowerCase().contains(serachItem.toLowerCase())) {
				result.add(catalog);
			}
		}
		return result;
	}
	
	@Override
	public boolean createCatalog(Catalog catalog) {
		for(Supplier supplier: supplierList) {
			System.out.println(supplier.getSupplierId()+"||"+catalog.getSupplierId());
			if((supplier.getSupplierId() == (catalog.getSupplierId()))) {
				catalogueList.add(new Catalog(catalog.getSkuName(), catalog.getSkuDescription(), catalog.getBrandName(), catalog.getBrandDescription(), catalog.getSupplierId()));
				System.out.println("Catalog is created");
				return true;
			}
		}
		System.out.println("Supplier not Exists");
		return false;
	}
	
	@Override
	public boolean createSupplier(String supplier) {
		supplierList.add(new Supplier(supplier));
		System.out.println("Supplier is created");
		return true;
	}
}
