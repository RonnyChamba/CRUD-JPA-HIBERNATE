package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.TipoTransporte;
import com.ideas.app.repository.TipoTransporteRepository;


@Service
@Transactional
public class TipoTransporteServiceImpl implements TipoTransporteService {

	
	@Autowired
	private TipoTransporteRepository tipoTransporteRepository;
	
	
	@Override
	public Iterable<TipoTransporte> list() {
		
		return  tipoTransporteRepository.findAll();
	}

	@Override
	public TipoTransporte buscarById(Integer codigo) {
	
		return tipoTransporteRepository.findById(codigo).orElse(null);
	}

	@Override
	public void delete(Integer codigo) {
	
		tipoTransporteRepository.deleteById(codigo);

	}

	@Override
	public void add(TipoTransporte tipoTransporte) {
	
		tipoTransporteRepository.save(tipoTransporte);

	}

	@Override
	public void update(TipoTransporte tipoTransporte) {
	
		tipoTransporteRepository.save(tipoTransporte);

	}

	
	@Override
	public Long count() {
		return  tipoTransporteRepository.count();
	}

}
