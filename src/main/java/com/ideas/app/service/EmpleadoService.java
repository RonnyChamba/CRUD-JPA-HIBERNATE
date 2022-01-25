package com.ideas.app.service;

import com.ideas.app.jpa.model.Empleado;

public interface EmpleadoService {

	Iterable<Empleado> empleadoList();

	void empleadoDelete(Integer id);

	Empleado buscarById(Integer codigo);
	void empleadoAdd(Empleado empleado);
	
	void actualizar(Empleado empleado);

	Long empleadoCount();

}
