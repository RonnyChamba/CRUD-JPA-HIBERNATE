package com.ideas.app.service;
import com.ideas.app.jpa.model.TipoViaje;

public interface TipoViajeService {
	
	Iterable<TipoViaje>  list();
	
	TipoViaje buscarById(Integer codigo);
	
	void delete(Integer codigo);
	
	void add(TipoViaje tipoViaje);
	
	void update(TipoViaje tipoViaje);
	
	Long count();	
}
