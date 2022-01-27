package com.ideas.app.service;

import com.ideas.app.jpa.model.Factura;

public interface FacturaService {

	Iterable<Factura> list();

	Factura buscarById(Integer codigo);

	void delete(Integer codigo);

	void add(Factura factura);
	
	void update(Factura factura);

	Long count();
}
