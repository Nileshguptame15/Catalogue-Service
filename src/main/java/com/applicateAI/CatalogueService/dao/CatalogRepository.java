package com.applicateAI.CatalogueService.dao;

import org.springframework.data.repository.CrudRepository;

import com.applicateAI.CatalogueService.model.Catalog;


public interface CatalogRepository extends CrudRepository<Catalog, Integer> {

}
