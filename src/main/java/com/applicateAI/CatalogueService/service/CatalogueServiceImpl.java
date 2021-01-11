package com.applicateAI.CatalogueService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applicateAI.CatalogueService.dao.CatalogueDAOImpl;
import com.applicateAI.CatalogueService.model.Catalog;
import com.applicateAI.CatalogueService.model.Supplier;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	CatalogueDAOImpl catalogueDAO;
	
	@Override
	public List<String> searchItems(String supplierName, String serachItem) {
		List<Catalog> cataLogList = catalogueDAO.searchItems(supplierName, serachItem);
		List<String> skuNames = new ArrayList<>();
		for(Catalog catalog: cataLogList) {
			skuNames.add(catalog.getSkuName());
		}
		return skuNames;
	}
	
	@Override
	public boolean createCatalog(Catalog catalog) {
		return catalogueDAO.createCatalog(catalog);
	}
	
	@Override
	public boolean createSupplier(String supplier) {
		return catalogueDAO.createSupplier(supplier);
	}
}
