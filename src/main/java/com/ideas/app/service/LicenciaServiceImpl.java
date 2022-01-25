package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.jpa.model.Licencia;
import com.ideas.app.repository.ConductorRepository;
import com.ideas.app.repository.LicenciaRepository;

@Service
@Transactional
public class LicenciaServiceImpl   implements LicenciaService{

	
	@Autowired
	private LicenciaRepository licenciaRepository;
	
	
	@Autowired
	private ConductorRepository conductorRepository;
	
	
	@Override
	public Iterable<Licencia> list() {
		
		
		return licenciaRepository.findAll();
	}

	
	@Override
	@Transactional
	public Licencia buscarById(Integer codigo) {
		
		
		Licencia licencia = licenciaRepository.findById(codigo).orElse(null);
		// Para resolver el problema de lazy, fuerzo a recupere el conductor, preguntando por su metodo toString()
		licencia.getConductor().toString();
		return licencia;
	}

	@Override
	public void delete(Integer codigo) {
		
		/*
		// Obtener la licencia que se eliminara
		Licencia licencia = licenciaRepository.findById(codigo).orElse(null);	
		
		//Obtener el conductor de la licencia
		Conductor conductor = licencia.getConductor();
		
		// eliminar la licencia: entrar al metodo para ver la logica
		conductor.deleteLicencia(licencia);
		
		*/
		
		
		licenciaRepository.deleteById(codigo);
		
	
	}

	@Override
	public void add(Licencia licencia) {
		
		// Busco el conductor y lo devuelve persistido
		Conductor conductor =  conductorRepository.findById(licencia.getConductor().getCodigo()).orElse(null);
		
		// Asigno el conductor persistido
		licencia.setConductor(conductor);
		licenciaRepository.save(licencia);
	}

	@Override
	public void update(Licencia licencia) {
		// Busco el conductor y lo devuelve persistido
		Conductor conductor =  conductorRepository.findById(licencia.getConductor().getCodigo()).orElse(null);
		
		// Asigno el conductor persistido
		licencia.setConductor(conductor);
		
		licenciaRepository.save(licencia);	
	}

	@Override
	public Long count() {
		
		return licenciaRepository.count();
	}


	@Override
	public Conductor conductorLicencia(Integer id) {
	
		System.out.println("ID DE CONDUCTOR: " + id);
		Conductor conductor = conductorRepository.findById(id).orElse(null);
		conductor.getLicencias().size();
		return conductor;
	}
	
	
}
