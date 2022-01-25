package com.ideas.app.service;

import com.ideas.app.jpa.model.Transporte;

public interface TransporteService {

	Iterable<Transporte> list();

	Transporte buscarById(Integer codigo);

	void delete(Integer codigo);

	void add(Transporte transporte);

	void update(Transporte transporte);

	Long count();

}
