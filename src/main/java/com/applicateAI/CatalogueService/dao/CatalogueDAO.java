package com.applicateAI.CatalogueService.dao;

import java.util.List;

import com.applicateAI.CatalogueService.model.Catalog;
import com.applicateAI.CatalogueService.model.Supplier;

public interface CatalogueDAO {

	List<Catalog> searchItems(String supplierName, String serachItem);

	boolean createCatalog(Catalog catalog);

	boolean createSupplier(String supplier);

}