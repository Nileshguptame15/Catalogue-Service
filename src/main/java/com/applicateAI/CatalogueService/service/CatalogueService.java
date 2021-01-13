package com.applicateAI.CatalogueService.service;

import java.util.List;

import com.applicateAI.CatalogueService.model.Catalog;

public interface CatalogueService {

	List<String> searchItems(String serachItem);

	boolean createCatalog(Catalog catalog);

	boolean createSupplier(String supplier);

}