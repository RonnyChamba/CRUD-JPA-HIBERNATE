package com.ideas.app.service;

import com.ideas.app.jpa.model.Destino;

public interface DestinoService {
	
	Iterable<Destino> list();

	Destino buscarById(Integer codigo);

	void delete(Integer codigo);

	void add(Destino destino);

	void update(Destino destino);

	Long count();

}
