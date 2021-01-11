package com.applicateAI.CatalogueService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applicateAI.CatalogueService.model.Catalog;
import com.applicateAI.CatalogueService.model.Supplier;
import com.applicateAI.CatalogueService.service.CatalogueServiceImpl;

@RestController
public class CatalogueController {

	@Autowired
	CatalogueServiceImpl catalogService;
	
	@GetMapping({"supplierName/{supplierName}/searchItem/{searchItem}"})
	public List<String> searchCatalogue(@PathVariable String supplierName ,@PathVariable String searchItem) {
		System.out.println(supplierName+"|"+searchItem);
		return catalogService.searchItems(supplierName, searchItem);
	}
	
	@PostMapping("/createCatalog")
	public boolean createCatalog(@RequestBody Catalog catalog) {
		return catalogService.createCatalog(catalog);
	}
	
	@PostMapping("/createSupplier/{supplierName}")
	public boolean createSupplier(@PathVariable String supplierName) {
		return catalogService.createSupplier(supplierName);
	}
}
