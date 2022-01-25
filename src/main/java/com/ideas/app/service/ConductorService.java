package com.ideas.app.service;

import com.ideas.app.jpa.model.Conductor;

public interface ConductorService {

	Iterable<Conductor>  conductorList();
	
	Conductor buscarById(Integer codigo);
	
	void conductorDelete(Integer codigo);
	
	void conductorAdd(Conductor conductor);
	
	void actualizar(Conductor conductor);
	
	Long conductorCount();	
	
}
