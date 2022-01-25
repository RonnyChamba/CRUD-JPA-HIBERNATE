package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.repository.ConductorRepository;


@Service
@Transactional
public class ConductorServiceImpl  implements ConductorService{

	
	@Autowired
	private ConductorRepository conductorRepository;
	
	
	
	@Override
	public Iterable<Conductor> conductorList() {
		
		return conductorRepository.findAll();
	}

	@Override
	
	public Conductor buscarById(Integer codigo) {
		
		return conductorRepository.findById(codigo).orElse(null);

	}

	@Override
	public void conductorDelete(Integer codigo) {
		
		
		conductorRepository.deleteById(codigo);
		
	}

	@Override
	public void conductorAdd(Conductor conductor) {
		
		
		conductorRepository.save(conductor);
		
	}

	@Override
	public void actualizar(Conductor conductor) {
	
		conductorRepository.save(conductor);
		
	}

	@Override
	public Long conductorCount() {
		
		
		return conductorRepository.count();
	}

}
