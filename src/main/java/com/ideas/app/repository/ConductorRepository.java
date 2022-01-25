package com.ideas.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ideas.app.jpa.model.Conductor;


@Repository
public interface ConductorRepository   extends CrudRepository<Conductor, Integer> {

	
}
