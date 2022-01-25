package com.ideas.app.service;
import com.ideas.app.jpa.model.TipoTransporte;


public interface TipoTransporteService {
	
	Iterable<TipoTransporte>  list();
	
	TipoTransporte buscarById(Integer codigo);
	
	void delete(Integer codigo);
	
	void add(TipoTransporte tipoTransporte);
	
	void update(TipoTransporte tipoTransporte);
	
	Long count();	
}
