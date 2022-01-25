package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.Empleado;
import com.ideas.app.repository.EmpleadoRepository;


@Service
@Transactional
public class EmpleadoServiceImpl  implements EmpleadoService{

	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public Iterable<Empleado> empleadoList() {
		
		return empleadoRepository.findAll();
	}

	@Override
	public void empleadoDelete(Integer id) {
	
		
		empleadoRepository.deleteById(id);
		
	}

	@Override
	public void empleadoAdd(Empleado empleado) {
		
		
		empleadoRepository.save(empleado);
		
	}

	@Override
	public void actualizar(Empleado empleado) {
		
		empleadoRepository.save(empleado);
		
	}

	@Override
	public Long empleadoCount() {
		
		return empleadoRepository.count();
	}

	@Override
	public Empleado buscarById(Integer codigo) {
		
		return empleadoRepository.findById(codigo).orElse(null);
	}
	
	

}
