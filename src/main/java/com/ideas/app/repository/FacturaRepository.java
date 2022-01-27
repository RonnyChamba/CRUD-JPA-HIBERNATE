package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.app.jpa.model.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Integer> {

	
}
