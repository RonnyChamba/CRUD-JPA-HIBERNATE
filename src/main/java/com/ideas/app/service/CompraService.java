package com.ideas.app.service;

import com.ideas.app.jpa.model.Compra;

public interface CompraService {

	Iterable<Compra> list();

	Compra buscarById(Integer codigo);

	void delete(Integer codigo);

	void add(Compra compra);

	void update(Compra compra);

	Long count();
	
}
