package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.app.jpa.model.Transporte;


@Repository
public interface TransporteRepository  extends CrudRepository<Transporte, Integer>{

}
