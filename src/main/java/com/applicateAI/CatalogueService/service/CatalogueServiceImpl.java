package com.applicateAI.CatalogueService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applicateAI.CatalogueService.dao.CatalogRepository;
import com.applicateAI.CatalogueService.dao.SupplierRepository;
import com.applicateAI.CatalogueService.model.Catalog;
import com.applicateAI.CatalogueService.model.Supplier;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	CatalogRepository catalogRepository;

	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public List<String> searchItems(String supplierName, String serachItem) {
		List<Catalog> result = new ArrayList();
		int supplierId = -1;
		/*
		 * Looking for supplier Id for foreign key in Catalog if not found by default
		 * value is -1
		 */
		List<Supplier> supplierList = (List<Supplier>) supplierRepository.findAll();
		for (Supplier supplier : supplierList) {
			if (supplier.getSupplierName().equalsIgnoreCase(supplierName)) {
				supplierId = supplier.getSupplierId();
				break;
			}
		}
		System.out.println(supplierId);
		/*
		 * Adding Catalog into list by search Results
		 */
		List<Catalog> catalogueList = (List<Catalog>) catalogRepository.findAll();
		for (Catalog catalog : catalogueList) {
			System.out.println(catalog.getSkuName());
			if (catalog.getSupplierId() == supplierId
					&& catalog.getSkuName().toLowerCase().contains(serachItem.toLowerCase())) {
				result.add(catalog);
			}
		}
		List<String> skuNames = new ArrayList<>();
		for (Catalog catalog : result) {
			skuNames.add(catalog.getSkuName());
		}
		return skuNames;
	}

	@Override
	public boolean createCatalog(Catalog catalog) {
		for (Supplier supplier : supplierRepository.findAll()) {
			if ((supplier.getSupplierId() == (catalog.getSupplierId()))) {
				catalogRepository.save(catalog);
				System.out.println("Catalog is created");
				return true;
			}
		}
		System.out.println("Supplier not Exists");
		return false;
	}

	@Override
	public boolean createSupplier(String supplier) {
		supplierRepository.save(new Supplier(supplier));
		return true;
	}
}
