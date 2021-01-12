package com.applicateAI.CatalogueService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.applicateAI.CatalogueService.dao.CatalogRepository;
import com.applicateAI.CatalogueService.dao.SupplierRepository;
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
	/*
	 * @Autowired SupplierRepository supplierRepository;
	 * 
	 * @Autowired CatalogRepository catalogRepository;
	 * 
	 * @GetMapping({"/"}) public String popu() { System.out.println("in comming");
	 * supplierRepository.save(new Supplier("A")); supplierRepository.save(new
	 * Supplier("B"));
	 * 
	 * catalogRepository.save(new Catalog("Haldiram Namkeen", null, null, null, 1));
	 * catalogRepository.save(new Catalog("Bingo 200 gm", null, null, null, 1));
	 * catalogRepository.save(new Catalog("Bingo 500 gm", null, null, null, 1));
	 * catalogRepository.save(new Catalog("Ashirwad Atta", null, "Ashirwad Atta",
	 * "Atta", 2)); catalogRepository.save(new Catalog("Samrat Atta", null,
	 * "Samrat Atta", "Atta", 2)); System.out.println("exit"); return
	 * "Data Populated";
	 * 
	 * }
	 */
}
