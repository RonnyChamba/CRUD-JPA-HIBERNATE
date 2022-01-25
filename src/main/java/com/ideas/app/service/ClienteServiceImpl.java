package com.ideas.app.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ideas.app.jpa.model.Cliente;
import com.ideas.app.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl  implements ClienteService  {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl() {}

	@Override
	public Iterable<Cliente> clienteList() {
		
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarById(Integer codigo) {
		
		
		 return clienteRepository.findById(codigo).orElse(null);
	}

	@Override
	public void clienteDelete(Integer codigo) {
		
		clienteRepository.deleteById(codigo);
		
	}

	@Override
	public void clienteAdd(Cliente cliente) {
	
		clienteRepository.save(cliente);
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		
		clienteRepository.save(cliente);
	}

	@Override
	public Long clienteCount() {
		
		return  clienteRepository.count();
	}
	
	
	

}
