package com.applicateAI.CatalogueService.service;

import java.util.List;

import com.applicateAI.CatalogueService.model.Catalog;
import com.applicateAI.CatalogueService.model.Supplier;

public interface CatalogueService {

	List<String> searchItems(String supplierName, String serachItem);

	boolean createCatalog(Catalog catalog);

	boolean createSupplier(String supplier);

}