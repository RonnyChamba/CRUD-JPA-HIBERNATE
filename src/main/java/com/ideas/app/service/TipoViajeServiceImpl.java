package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.TipoViaje;
import com.ideas.app.repository.TipoViajeRepository;

@Service
@Transactional
public class TipoViajeServiceImpl  implements TipoViajeService{

	
	
	@Autowired
	private TipoViajeRepository tipoViajeRepository;
	
	@Override
	public Iterable<TipoViaje> list() {
		
		return tipoViajeRepository.findAll();
	}

	@Override
	public TipoViaje buscarById(Integer codigo) {
		
		return tipoViajeRepository.findById(codigo).orElse(null);
	}

	@Override
	public void delete(Integer codigo) {
		
		tipoViajeRepository.deleteById(codigo);
		
	}

	@Override
	public void add(TipoViaje tipoViaje) {
	
		tipoViajeRepository.save(tipoViaje);
		
	}

	@Override
	public void update(TipoViaje tipoViaje) {
	
		tipoViajeRepository.save(tipoViaje);
		
	}

	@Override
	public Long count() {
		return  tipoViajeRepository.count();
	}

	
}
