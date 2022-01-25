package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.app.jpa.model.Licencia;

@Repository
public interface LicenciaRepository extends CrudRepository<Licencia, Integer> {

	
}
