package com.ideas.app.service;

import com.ideas.app.jpa.model.Cliente;
public interface ClienteService {
	
	Iterable<Cliente>  clienteList();
	
	Cliente buscarById(Integer codigo);
	
	void clienteDelete(Integer codigo);
	
	void clienteAdd(Cliente cliente);
	
	void actualizar(Cliente cliente);
	
	Long clienteCount();	
	
}
