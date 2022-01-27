package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.app.jpa.model.Compra;

@Repository
public interface CompraRepository  extends CrudRepository<Compra, Integer>{

}

