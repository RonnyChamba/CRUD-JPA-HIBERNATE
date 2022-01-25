package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.app.jpa.model.TipoTransporte;

/**
 * interface  CrudRepository implementa metodos  para realizar un CRUD
 * @author user
 *
 */


@Repository
public interface TipoTransporteRepository extends CrudRepository<TipoTransporte, Integer>   {
	
	

	
}

