package com.ideas.app.service;

import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.jpa.model.Licencia;
public interface LicenciaService {

	Iterable<Licencia> list();
	
	Conductor conductorLicencia(Integer id);
	
	Licencia buscarById(Integer codigo);
	
	void delete(Integer codigo);

	void add(Licencia licencia);

	void update(Licencia licencia);
	

	Long count();

}
