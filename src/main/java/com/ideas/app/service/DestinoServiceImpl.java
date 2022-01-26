package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.Destino;
import com.ideas.app.repository.DestinoRepository;


@Service
@Transactional
public class DestinoServiceImpl implements DestinoService {


	@Autowired
	private DestinoRepository destinoRepository;
	
	@Override 
	public Iterable<Destino> list() {
		
		
		Iterable<Destino> destinos = destinoRepository.findAll();
		
		for(Destino destino: destinos) {
			destino.getTipoViaje().toString();
		}
		
		return  destinos;	
	}

	@Override
	public Destino buscarById(Integer codigo) {
		
		
		Destino destino =  destinoRepository.findById(codigo).orElse(null);
		
		destino.getTipoViaje().toString();
		
		return destino; 
	}

	@Override
	public void delete(Integer codigo) {
	
		destinoRepository.deleteById(codigo);
	}

	@Override
	public void add(Destino destino) {		
		destinoRepository.save(destino);

	}

	@Override
	public void update(Destino destino) {
		
		destinoRepository.save(destino);
	}

	@Override
	public Long count() {
		
		return destinoRepository.count();
	}

}
