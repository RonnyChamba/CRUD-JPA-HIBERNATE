package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.app.jpa.model.Destino;

@Repository
public interface DestinoRepository  extends  CrudRepository<Destino,Integer>{

	
	
}
